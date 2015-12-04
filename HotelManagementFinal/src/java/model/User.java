package model;

import java.io.Serializable;

/**
 *
 * @author Jordan Grimes
 */
public class User implements Serializable {

    private String name;
    private int room;
    private String indate;
    private String outdate;
    private String notes;

    public User() {
        name = "none";
        room = 0;
        indate = "1970-01-01";
        outdate = "1970-01-01";
        notes = "none";
    }

    public User(String name, int room, String indate, String outdate, String notes) {
        this.name = name;
        this.room = room;
        this.indate = indate;
        this.outdate = outdate;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getInDate() {
        return indate;
    }

    public void setInDate(String indate) {
        this.indate = indate;
    }

    public String getOutDate() {
        return outdate;
    }

    public void setOutDate(String outdate) {
        this.outdate = outdate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String inHTMLRowFormat() {
        return "<td>" + name + "</td>"
                + "<td>" + room + "</td>"
                + "<td>" + indate + "</td>"
                + "<td>" + outdate + "</td>"
                + "<td>" + notes + "</td></tr>\n";
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", room="
                + room + ", indate=" + indate + ", outdate=" + outdate
                + ", notes=" + notes + '}';
    }
}
