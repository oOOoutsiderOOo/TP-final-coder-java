package com.coder.trabajofinal.models.schemas;

import java.util.Objects;

public class DateApiResponse {

    private String abbreviation;
    private String client_ip;
    private String datetime;
    private int day_of_week;
    private int day_of_year;
    private boolean dst;
    private String dst_from;
    private int dst_offset;
    private String dst_until;
    private int raw_offset;
    private String timezone;
    private int unixtime;
    private String utc_datetime;
    private String utc_offset;
    private int week_number;

    public DateApiResponse() {
    }

    public DateApiResponse(String abbreviation, String client_ip, String datetime, int day_of_week, int day_of_year,
            boolean dst, String dst_from, int dst_offset, String dst_until, int raw_offset, String timezone,
            int unixtime, String utc_datetime, String utc_offset, int week_number) {
        this.abbreviation = abbreviation;
        this.client_ip = client_ip;
        this.datetime = datetime;
        this.day_of_week = day_of_week;
        this.day_of_year = day_of_year;
        this.dst = dst;
        this.dst_from = dst_from;
        this.dst_offset = dst_offset;
        this.dst_until = dst_until;
        this.raw_offset = raw_offset;
        this.timezone = timezone;
        this.unixtime = unixtime;
        this.utc_datetime = utc_datetime;
        this.utc_offset = utc_offset;
        this.week_number = week_number;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getClient_ip() {
        return this.client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }

    public String getDatetime() {
        return this.datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getDay_of_week() {
        return this.day_of_week;
    }

    public void setDay_of_week(int day_of_week) {
        this.day_of_week = day_of_week;
    }

    public int getDay_of_year() {
        return this.day_of_year;
    }

    public void setDay_of_year(int day_of_year) {
        this.day_of_year = day_of_year;
    }

    public boolean isDst() {
        return this.dst;
    }

    public boolean getDst() {
        return this.dst;
    }

    public void setDst(boolean dst) {
        this.dst = dst;
    }

    public String getDst_from() {
        return this.dst_from;
    }

    public void setDst_from(String dst_from) {
        this.dst_from = dst_from;
    }

    public int getDst_offset() {
        return this.dst_offset;
    }

    public void setDst_offset(int dst_offset) {
        this.dst_offset = dst_offset;
    }

    public String getDst_until() {
        return this.dst_until;
    }

    public void setDst_until(String dst_until) {
        this.dst_until = dst_until;
    }

    public int getRaw_offset() {
        return this.raw_offset;
    }

    public void setRaw_offset(int raw_offset) {
        this.raw_offset = raw_offset;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getUnixtime() {
        return this.unixtime;
    }

    public void setUnixtime(int unixtime) {
        this.unixtime = unixtime;
    }

    public String getUtc_datetime() {
        return this.utc_datetime;
    }

    public void setUtc_datetime(String utc_datetime) {
        this.utc_datetime = utc_datetime;
    }

    public String getUtc_offset() {
        return this.utc_offset;
    }

    public void setUtc_offset(String utc_offset) {
        this.utc_offset = utc_offset;
    }

    public int getWeek_number() {
        return this.week_number;
    }

    public void setWeek_number(int week_number) {
        this.week_number = week_number;
    }

    public DateApiResponse abbreviation(String abbreviation) {
        setAbbreviation(abbreviation);
        return this;
    }

    public DateApiResponse client_ip(String client_ip) {
        setClient_ip(client_ip);
        return this;
    }

    public DateApiResponse datetime(String datetime) {
        setDatetime(datetime);
        return this;
    }

    public DateApiResponse day_of_week(int day_of_week) {
        setDay_of_week(day_of_week);
        return this;
    }

    public DateApiResponse day_of_year(int day_of_year) {
        setDay_of_year(day_of_year);
        return this;
    }

    public DateApiResponse dst(boolean dst) {
        setDst(dst);
        return this;
    }

    public DateApiResponse dst_from(String dst_from) {
        setDst_from(dst_from);
        return this;
    }

    public DateApiResponse dst_offset(int dst_offset) {
        setDst_offset(dst_offset);
        return this;
    }

    public DateApiResponse dst_until(String dst_until) {
        setDst_until(dst_until);
        return this;
    }

    public DateApiResponse raw_offset(int raw_offset) {
        setRaw_offset(raw_offset);
        return this;
    }

    public DateApiResponse timezone(String timezone) {
        setTimezone(timezone);
        return this;
    }

    public DateApiResponse unixtime(int unixtime) {
        setUnixtime(unixtime);
        return this;
    }

    public DateApiResponse utc_datetime(String utc_datetime) {
        setUtc_datetime(utc_datetime);
        return this;
    }

    public DateApiResponse utc_offset(String utc_offset) {
        setUtc_offset(utc_offset);
        return this;
    }

    public DateApiResponse week_number(int week_number) {
        setWeek_number(week_number);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DateApiResponse)) {
            return false;
        }
        DateApiResponse dateApiResponse = (DateApiResponse) o;
        return Objects.equals(abbreviation, dateApiResponse.abbreviation)
                && Objects.equals(client_ip, dateApiResponse.client_ip)
                && Objects.equals(datetime, dateApiResponse.datetime) && day_of_week == dateApiResponse.day_of_week
                && day_of_year == dateApiResponse.day_of_year && dst == dateApiResponse.dst
                && Objects.equals(dst_from, dateApiResponse.dst_from) && dst_offset == dateApiResponse.dst_offset
                && Objects.equals(dst_until, dateApiResponse.dst_until) && raw_offset == dateApiResponse.raw_offset
                && Objects.equals(timezone, dateApiResponse.timezone) && unixtime == dateApiResponse.unixtime
                && Objects.equals(utc_datetime, dateApiResponse.utc_datetime)
                && Objects.equals(utc_offset, dateApiResponse.utc_offset) && week_number == dateApiResponse.week_number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(abbreviation, client_ip, datetime, day_of_week, day_of_year, dst, dst_from, dst_offset,
                dst_until, raw_offset, timezone, unixtime, utc_datetime, utc_offset, week_number);
    }

    @Override
    public String toString() {
        return "{" +
                " abbreviation='" + getAbbreviation() + "'" +
                ", client_ip='" + getClient_ip() + "'" +
                ", datetime='" + getDatetime() + "'" +
                ", day_of_week='" + getDay_of_week() + "'" +
                ", day_of_year='" + getDay_of_year() + "'" +
                ", dst='" + isDst() + "'" +
                ", dst_from='" + getDst_from() + "'" +
                ", dst_offset='" + getDst_offset() + "'" +
                ", dst_until='" + getDst_until() + "'" +
                ", raw_offset='" + getRaw_offset() + "'" +
                ", timezone='" + getTimezone() + "'" +
                ", unixtime='" + getUnixtime() + "'" +
                ", utc_datetime='" + getUtc_datetime() + "'" +
                ", utc_offset='" + getUtc_offset() + "'" +
                ", week_number='" + getWeek_number() + "'" +
                "}";
    }

}
