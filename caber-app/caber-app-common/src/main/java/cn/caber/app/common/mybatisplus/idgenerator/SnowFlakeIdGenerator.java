package cn.caber.app.common.mybatisplus.idgenerator;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * SnowFlake的结构如下(每部分用-分开):<br>
 * 0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 - 000000000000 <br>
 * 1位标识，由于long基本类型在Java中是带符号的，最高位是符号位，正数是0，负数是1，所以id一般是正数，最高位是0<br>
 * 41位时间截(毫秒级)，注意，41位时间截不是存储当前时间的时间截，而是存储时间截的差值（当前时间截 - 开始时间截得到的值），
 * 这里的的开始时间截，一般是我们的id生成器开始使用的时间，由我们程序来指定的（如下下面程序IdWorker类的startTime属性）。
 * 41位的时间截，可以使用69年，年T = (1L << 41) / (1000L * 60 * 60 * 24 * 365) = 69<br>
 * 10位的数据机器位，可以部署在1024个节点，包括5位datacenterId和5位workerId<br>
 * 12位序列，毫秒内的计数，12位的计数顺序号支持每个节点每毫秒(同一机器，同一时间截)产生4096个ID序号<br>
 * 加起来刚好64位，为一个Long型。<br>
 * SnowFlake的优点是，整体上按照时间自增排序，并且整个分布式系统内不会产生ID碰撞(由数据中心ID和机器ID作区分)，
 * 并且效率较高，经测试，SnowFlake每秒能够产生26万ID左右。
 */
public class SnowFlakeIdGenerator {
    //起始时间戳( 2023-1-1 00:00:00 )
    private static final long START_STAMP = 1672502400L;

    //序列号占用位数
    private static final long SEQUENCE_BIT = 12;

    //机器标识占用位数
    private static final long MACHINE_BIT = 5;

    //数据中心占用位数
    private static final long DATACENTER_BIT = 5;

    //序列号最大值
    private static final long MAX_SEQUENCE = -1L ^ (-1L << 12); // 4095

    /**
     * 偏移量
     **/
    private static final long MACHINE_LEFT = SEQUENCE_BIT;  // 12

    private static final long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT; // 17

    private static final long TIMESTAMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT; //  22

    private static long dataCenterId; //0,  数据中心(0-31)
    private static long machineId; //0,  机器标识(0-31)

    private static long sequence; //序列号  range(0 ~ 4095)
    private static long lastStamp; //上一次时间戳


    private static void setMachineId(){
        // todo  通过zookeeper设置机器id
    }

    public static synchronized long getNextId() {

        long currentStamp = System.currentTimeMillis();

        if (currentStamp < lastStamp) {
            throw new IllegalArgumentException("时间被回退，不能继续产生id");
        }

        if (currentStamp == lastStamp) {
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            if (sequence == 0L) {
                //序列号已经到最大值，使用下一个时间戳
                currentStamp = untilNextStamp();
            }
        } else {
            //不同毫秒，序列号重置
            sequence = 0L;
        }

        lastStamp = currentStamp;//当前时间戳存档，用于判断下次产生id时间戳是否相同

        return (currentStamp - START_STAMP) << TIMESTAMP_LEFT
                | dataCenterId << DATACENTER_LEFT
                | machineId << MACHINE_LEFT
                | sequence;

    }

    /**
     * 阻塞直至获得下一个时间戳
     *
     * @return
     */
    public static long untilNextStamp() {
        long newStamp = getCurrentStamp();
        while (newStamp <= lastStamp) {
            newStamp = getCurrentStamp();
        }
        return newStamp;
    }

    /**
     * 获取当前时间戳
     *
     * @return
     */
    public static long getCurrentStamp() {
        long currentStamp = System.currentTimeMillis();
        if (currentStamp < lastStamp) {
            // ++ 使得效率更快
            currentStamp++;
        }
        return currentStamp;

    }


}
