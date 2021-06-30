package design_mode.model10;

import java.io.*;
import java.util.Date;

// 被克隆类实现Cloneable接口表明其支持被克隆
// 实现Serializable接口使该类对象可序列化，以此来达到深克隆
public class Monkey implements Cloneable, Serializable {

    //身高
    private int height;
    //体重
    private int weight;
    //生日
    private Date birthDate;

    //金箍棒
    private GoldRingedStaff staff;

    public Monkey() {
        this.birthDate = new Date();
        this.staff = new GoldRingedStaff();
    }

    // 覆写的Object类里的clone()属于浅克隆
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // 自定义的深克隆
    public Object deepClone() throws IOException, ClassNotFoundException {
        //将对象写到流里
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        //从流里读回来
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public GoldRingedStaff getStaff() {
        return staff;
    }

    public void setStaff(GoldRingedStaff staff) {
        this.staff = staff;
    }
}
