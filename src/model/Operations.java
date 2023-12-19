/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author danyal
 */
public class Operations {
     String opt_id, name, operation, date, time;

    public Operations(String opt_id, String name, String operation, String date, String time) {
        this.opt_id = opt_id;
        this.name = name;
        this.operation = operation;
        this.date = date;
        this.time = time;
    }

    public String getOpt_id() {
        return opt_id;
    }

    public void setOpt_id(String opt_id) {
        this.opt_id = opt_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Operations{" + "opt_id=" + opt_id + ", name=" + name + ", operation=" + operation + ", date=" + date + ", time=" + time + '}';
    }
}
