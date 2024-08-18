package com.xq.streaming_example.bean;

/**
 * @author zhangxiaoqiong
 * @desc b_track
 * @date 2021/1/11 13:44
 */
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

//@Table(name="b_track")
public class BTrack implements Serializable,Cloneable {
    /** id */
    private String id;
    /** 车辆id */
    private String truckId;
    /** 车牌 */
    private String licensePlate;
    /** 设备号 */
    private String imei;
    /** 地址 */
    private String addressName;
    /** 海拔 */
    private Integer altitude;
    /** 速度 */
    private BigDecimal speed;
    /** 方向角 */
    private Integer drivingDirection;
    /** 经度 */
    private BigDecimal longitude;
    /** 纬度 */
    private BigDecimal latitude;
    /** gps时间戳 */
    private Integer gps;
    /** 回传时间 */
    private Date backTime;
    /** 道路名 */
    private String roadName;
    /** 道路编号 */
    private String roadCode;
    /** 道路等级 */
    private String roadLevel;
    /** 道路限速 */
    private BigDecimal roadSpeedLimit;
    /** back_seq_no */
    private String backSeqNo;
    /** gps时间 */
    private Date gpsTime;
    /** 创建时间 */
    private Date createTime;
    /** del_flag */
    private Integer delFlag;
    /** is_new */
    private Integer isNew;
    /** isconsumed */
    private String isconsumed;
    /** alarm_type0 */
    private String alarmType0;
    /** alarm_name0 */
    private String alarmName0;
    /** alarm_type1 */
    private String alarmType1;
    /** alarm_name1 */
    private String alarmName1;
    /** alarm_photo_linkurl */
    private String alarmPhotoLinkurl;
    /** 司机id */
    private String travelId;
    /** 更新时间 */
    private Date updateTime;
    /** 是否补传（0 正常 1 补传） */
    private Integer isDelay;
    /** 与前车的距离 单位 0.1m */
    private BigDecimal vehicleDistance;
    /** 1:无人脸  2 有人脸 */
    private Integer hasFace;
    /** 行驶里程 */
    private BigDecimal mileage;
    /** hbaseId */
    private  String hbaseId ;

    public BTrack() {
    }

    public BTrack(String id, String truckId, String licensePlate, String imei, String addressName, Integer altitude, BigDecimal speed, Integer drivingDirection, BigDecimal longitude, BigDecimal latitude, Integer gps, Date backTime, String roadName, String roadCode, String roadLevel, BigDecimal roadSpeedLimit, String backSeqNo, Date gpsTime, Date createTime, Integer delFlag, Integer isNew, String isconsumed, String alarmType0, String alarmName0, String alarmType1, String alarmName1, String alarmPhotoLinkurl, String travelId, Date updateTime, Integer isDelay, BigDecimal vehicleDistance, Integer hasFace, BigDecimal mileage, String hbaseId) {
        this.id = id;
        this.truckId = truckId;
        this.licensePlate = licensePlate;
        this.imei = imei;
        this.addressName = addressName;
        this.altitude = altitude;
        this.speed = speed;
        this.drivingDirection = drivingDirection;
        this.longitude = longitude;
        this.latitude = latitude;
        this.gps = gps;
        this.backTime = backTime;
        this.roadName = roadName;
        this.roadCode = roadCode;
        this.roadLevel = roadLevel;
        this.roadSpeedLimit = roadSpeedLimit;
        this.backSeqNo = backSeqNo;
        this.gpsTime = gpsTime;
        this.createTime = createTime;
        this.delFlag = delFlag;
        this.isNew = isNew;
        this.isconsumed = isconsumed;
        this.alarmType0 = alarmType0;
        this.alarmName0 = alarmName0;
        this.alarmType1 = alarmType1;
        this.alarmName1 = alarmName1;
        this.alarmPhotoLinkurl = alarmPhotoLinkurl;
        this.travelId = travelId;
        this.updateTime = updateTime;
        this.isDelay = isDelay;
        this.vehicleDistance = vehicleDistance;
        this.hasFace = hasFace;
        this.mileage = mileage;
        this.hbaseId = hbaseId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTruckId() {
        return truckId;
    }

    public void setTruckId(String truckId) {
        this.truckId = truckId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public Integer getAltitude() {
        return altitude;
    }

    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    public BigDecimal getSpeed() {
        return speed;
    }

    public void setSpeed(BigDecimal speed) {
        this.speed = speed;
    }

    public Integer getDrivingDirection() {
        return drivingDirection;
    }

    public void setDrivingDirection(Integer drivingDirection) {
        this.drivingDirection = drivingDirection;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Integer getGps() {
        return gps;
    }

    public void setGps(Integer gps) {
        this.gps = gps;
    }

    public Date getBackTime() {
        return backTime;
    }

    public void setBackTime(Date backTime) {
        this.backTime = backTime;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getRoadCode() {
        return roadCode;
    }

    public void setRoadCode(String roadCode) {
        this.roadCode = roadCode;
    }

    public String getRoadLevel() {
        return roadLevel;
    }

    public void setRoadLevel(String roadLevel) {
        this.roadLevel = roadLevel;
    }

    public BigDecimal getRoadSpeedLimit() {
        return roadSpeedLimit;
    }

    public void setRoadSpeedLimit(BigDecimal roadSpeedLimit) {
        this.roadSpeedLimit = roadSpeedLimit;
    }

    public String getBackSeqNo() {
        return backSeqNo;
    }

    public void setBackSeqNo(String backSeqNo) {
        this.backSeqNo = backSeqNo;
    }

    public Date getGpsTime() {
        return gpsTime;
    }

    public void setGpsTime(Date gpsTime) {
        this.gpsTime = gpsTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    public String getIsconsumed() {
        return isconsumed;
    }

    public void setIsconsumed(String isconsumed) {
        this.isconsumed = isconsumed;
    }

    public String getAlarmType0() {
        return alarmType0;
    }

    public void setAlarmType0(String alarmType0) {
        this.alarmType0 = alarmType0;
    }

    public String getAlarmName0() {
        return alarmName0;
    }

    public void setAlarmName0(String alarmName0) {
        this.alarmName0 = alarmName0;
    }

    public String getAlarmType1() {
        return alarmType1;
    }

    public void setAlarmType1(String alarmType1) {
        this.alarmType1 = alarmType1;
    }

    public String getAlarmName1() {
        return alarmName1;
    }

    public void setAlarmName1(String alarmName1) {
        this.alarmName1 = alarmName1;
    }

    public String getAlarmPhotoLinkurl() {
        return alarmPhotoLinkurl;
    }

    public void setAlarmPhotoLinkurl(String alarmPhotoLinkurl) {
        this.alarmPhotoLinkurl = alarmPhotoLinkurl;
    }

    public String getTravelId() {
        return travelId;
    }

    public void setTravelId(String travelId) {
        this.travelId = travelId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelay() {
        return isDelay;
    }

    public void setIsDelay(Integer isDelay) {
        this.isDelay = isDelay;
    }

    public BigDecimal getVehicleDistance() {
        return vehicleDistance;
    }

    public void setVehicleDistance(BigDecimal vehicleDistance) {
        this.vehicleDistance = vehicleDistance;
    }

    public Integer getHasFace() {
        return hasFace;
    }

    public void setHasFace(Integer hasFace) {
        this.hasFace = hasFace;
    }

    public BigDecimal getMileage() {
        return mileage;
    }

    public void setMileage(BigDecimal mileage) {
        this.mileage = mileage;
    }

    public String getHbaseId() {
        return hbaseId;
    }

    public void setHbaseId(String hbaseId) {
        this.hbaseId = hbaseId;
    }

    @Override
    public String toString() {
        return "BTrack{" +
                "id='" + id + '\'' +
                ", truckId='" + truckId + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", imei='" + imei + '\'' +
                ", addressName='" + addressName + '\'' +
                ", altitude=" + altitude +
                ", speed=" + speed +
                ", drivingDirection=" + drivingDirection +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", gps=" + gps +
                ", backTime=" + backTime +
                ", roadName='" + roadName + '\'' +
                ", roadCode='" + roadCode + '\'' +
                ", roadLevel='" + roadLevel + '\'' +
                ", roadSpeedLimit=" + roadSpeedLimit +
                ", backSeqNo='" + backSeqNo + '\'' +
                ", gpsTime=" + gpsTime +
                ", createTime=" + createTime +
                ", delFlag=" + delFlag +
                ", isNew=" + isNew +
                ", isconsumed='" + isconsumed + '\'' +
                ", alarmType0='" + alarmType0 + '\'' +
                ", alarmName0='" + alarmName0 + '\'' +
                ", alarmType1='" + alarmType1 + '\'' +
                ", alarmName1='" + alarmName1 + '\'' +
                ", alarmPhotoLinkurl='" + alarmPhotoLinkurl + '\'' +
                ", travelId='" + travelId + '\'' +
                ", updateTime=" + updateTime +
                ", isDelay=" + isDelay +
                ", vehicleDistance=" + vehicleDistance +
                ", hasFace=" + hasFace +
                ", mileage=" + mileage +
                ", hbaseId='" + hbaseId + '\'' +
                '}';
    }
}
