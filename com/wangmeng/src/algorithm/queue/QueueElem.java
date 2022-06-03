package algorithm.queue;

class QueueElem
{
    public int flowID;
    public double packetLen;
    public double virtualFinTime;

    public double remaining_Virt_len;
    public double last_update_time;
    public double remaining_TransTime;

    public QueueElem next;
}
