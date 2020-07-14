package com.spring.henallux.springproject.dataAccess.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="command")
public class CommandEntity {

    public CommandEntity(){

    }

    @Id
    @Column(name="id")
    private int id;

    @Column(name="date")
    private Date date;

    @JoinColumn(name="user_id", referencedColumnName = "username")
    @ManyToOne
    private UserEntity user;

    @OneToMany(mappedBy = "command", fetch = FetchType.EAGER)
    private List<CommandLineEntity> commandLines;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<CommandLineEntity> getCommandLines() {
        return commandLines;
    }

    public void setCommandLines(List<CommandLineEntity> commandLines) {
        this.commandLines = commandLines;
    }
}
