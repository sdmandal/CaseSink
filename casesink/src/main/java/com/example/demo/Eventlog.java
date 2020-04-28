package com.example.demo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the eventlog database table.
 * 
 */
@Entity
@Table(name="eventlog")
@NamedQuery(name="Eventlog.findAll", query="SELECT e FROM Eventlog e")
public class Eventlog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String corelationid;

	private Timestamp createtime;

	private String eventid;

	private String eventsource;

	private String eventtype;

	private String payload;

	public int getEventsequence() {
		return eventsequence;
	}

	public void setEventsequence(int eventsequence) {
		this.eventsequence = eventsequence;
	}

	private int eventsequence;

	public Eventlog() {
	}

	public Eventlog(String corelationid, String eventid, String eventsource,
			String eventtype, String payload,int eventsequence) {
		this.corelationid = corelationid;
		this.eventid = eventid;
		this.eventsource = eventsource;
		this.eventtype = eventtype;
		this.payload = payload;
		this.eventsequence=eventsequence;
		}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorelationid() {
		return this.corelationid;
	}

	public void setCorelationid(String corelationid) {
		this.corelationid = corelationid;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getEventid() {
		return this.eventid;
	}

	public void setEventid(String eventid) {
		this.eventid = eventid;
	}

	public String getEventsource() {
		return this.eventsource;
	}

	public void setEventsource(String eventsource) {
		this.eventsource = eventsource;
	}

	public String getEventtype() {
		return this.eventtype;
	}

	public void setEventtype(String eventtype) {
		this.eventtype = eventtype;
	}

	public String getPayload() {
		return this.payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

}