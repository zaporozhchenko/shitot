package com.shitot.model;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.Set;

/**
 * Created by Next on 12.07.2016.
 * Slot is workingDay, you may create 7 slots for every clinic with empty set of intervals
 */
@Entity(name = "slots")
public class Slot extends BaseEntity{

    @Enumerated
    @Column(name = "day_of_week")
    private DayOfWeek dayOfWeek;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "slot_intervals", joinColumns = @JoinColumn(name = "slot_id"))
    @Column(name = "interv")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Interval> intervals;

    public Slot() {
    }

    public Slot(DayOfWeek dayOfWeek, Set<Interval> intervals) {
        this.dayOfWeek = dayOfWeek;
        this.intervals = intervals;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Set<Interval> getIntervals() {
        return intervals;
    }

    public void setIntervals(Set<Interval> intervals) {
        this.intervals = intervals;
    }

    @Override
    public String toString() {
        return "Slot{" +
                   "dayOfWeek=" + dayOfWeek +
                   ", intervals=" + intervals +
                   '}';
    }
}
