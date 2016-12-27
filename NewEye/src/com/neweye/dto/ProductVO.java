package com.neweye.dto;

import java.sql.Timestamp;

public class ProductVO {
	private int pseq; // 상품번호
	private String first_level; // 대분류
	private String second_level; // 중분류
	private String kind; // 상품분류번호
	private String name; // 상품명
	private int price; // 가격
	private Timestamp indate; // 출시일
	private int read_count; // 조회수
	private int quantity; // 수량
	private String useyn; // 상품삭제여부
	private String content; // 상품설명
	private String img_list; // 이미지명
	private String img_detail; // 상세이미지명
	private String sizee; // 크기
	private int weight; // 무게
	private float ratio; // 센서크기
	private int pixel; // 화소
	private int speed; // 최소셔터스피드
	private int seqpictures; // 최대연속촬영속도
	private float screen; // 화면크기
	private int iso; // 최대ISO감도
	private int movframe; // 동영상프레임
	private String format; // 렌즈포맷
	private int filter; // 필터구경
	private String functions; // 렌즈기능
	private String zoomyn; // 줌여부
	private float minfocus; // 최소초점거리
	private float maxfocus; // 최대초첨거리
	private float minaperture; // 최소조리개
	private float maxaperture; // 최대조리개
	private float distance; // 최소촬영거리
	private String types; // 액세서리 분류
	public int getPseq() {
		return pseq;
	}
	public void setPseq(int pseq) {
		this.pseq = pseq;
	}
	public String getFirst_level() {
		return first_level;
	}
	public void setFirst_level(String first_level) {
		this.first_level = first_level;
	}
	public String getSecond_level() {
		return second_level;
	}
	public void setSecond_level(String second_level) {
		this.second_level = second_level;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	public int getRead_count() {
		return read_count;
	}
	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUseyn() {
		return useyn;
	}
	public void setUseyn(String useyn) {
		this.useyn = useyn;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg_list() {
		return img_list;
	}
	public void setImg_list(String img_list) {
		this.img_list = img_list;
	}
	public String getImg_detail() {
		return img_detail;
	}
	public void setImg_detail(String img_detail) {
		this.img_detail = img_detail;
	}
	public String getSizee() {
		return sizee;
	}
	public void setSizee(String sizee) {
		this.sizee = sizee;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public float getRatio() {
		return ratio;
	}
	public void setRatio(float ratio) {
		this.ratio = ratio;
	}
	public int getPixel() {
		return pixel;
	}
	public void setPixel(int pixel) {
		this.pixel = pixel;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getSeqpictures() {
		return seqpictures;
	}
	public void setSeqpictures(int seqpictures) {
		this.seqpictures = seqpictures;
	}
	public float getScreen() {
		return screen;
	}
	public void setScreen(float screen) {
		this.screen = screen;
	}
	public int getIso() {
		return iso;
	}
	public void setIso(int iso) {
		this.iso = iso;
	}
	public int getMovframe() {
		return movframe;
	}
	public void setMovframe(int movframe) {
		this.movframe = movframe;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public int getFilter() {
		return filter;
	}
	public void setFilter(int filter) {
		this.filter = filter;
	}
	public String getFunctions() {
		return functions;
	}
	public void setFunctions(String functions) {
		this.functions = functions;
	}
	public String getZoomyn() {
		return zoomyn;
	}
	public void setZoomyn(String zoomyn) {
		this.zoomyn = zoomyn;
	}
	public float getMinfocus() {
		return minfocus;
	}
	public void setMinfocus(float minfocus) {
		this.minfocus = minfocus;
	}
	public float getMaxfocus() {
		return maxfocus;
	}
	public void setMaxfocus(float maxfocus) {
		this.maxfocus = maxfocus;
	}
	public float getMinaperture() {
		return minaperture;
	}
	public void setMinaperture(float minaperture) {
		this.minaperture = minaperture;
	}
	public float getMaxaperture() {
		return maxaperture;
	}
	public void setMaxaperture(float maxaperture) {
		this.maxaperture = maxaperture;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}

	

}
