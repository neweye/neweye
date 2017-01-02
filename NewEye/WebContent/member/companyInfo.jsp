<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style>
.strong{

float: left;
    margin-top: -0.2em;
    margin-right: 0.3em;
    color: #333;
    font-size: 28px;
    font-weight: bold;
    letter-spacing: -0.08em;
    }
    
table{
    display: table;
    border-collapse: separate;
    border-spacing: 2px;
    border-color: grey;
}

tr{
    display: table-row;
    vertical-align: inherit;
    border-color: inherit;}
    
    /* td { background-color:#FFDDDD; padding:10px; border:1px solid #ACB4F2; } */
</style>





<link href="http://code.google.com/apis/maps/documentation/javascript/examples/default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="http://maps.google.com/maps/api/js?key=AIzaSyDIyUE4bQVaJsDVCvGTPGaTpcUani6h1VI"></script>
<script type="text/javascript">
      function initialize() {
        var mapLocation = new google.maps.LatLng('36.325054', ' 127.420061'); // 지도에서 가운데로 위치할 위도와 경도
        var markLocation = new google.maps.LatLng('36.325054', ' 127.420061'); // 마커가 위치할 위도와 경도
         
        var mapOptions = {
          center: mapLocation, // 지도에서 가운데로 위치할 위도와 경도(변수)
          zoom: 18, // 지도 zoom단계
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById("map-canvas"), // id: map-canvas, body에 있는 div태그의 id와 같아야 함
            mapOptions);
         
        var size_x = 60; // 마커로 사용할 이미지의 가로 크기
        var size_y = 60; // 마커로 사용할 이미지의 세로 크기
         
        // 마커로 사용할 이미지 주소
        var image = new google.maps.MarkerImage( 'http://www.larva.re.kr/home/img/boximage3.png',
                            new google.maps.Size(size_x, size_y),
                            '',
                            '',
                            new google.maps.Size(size_x, size_y));
         
        var marker;
        marker = new google.maps.Marker({
               position: markLocation, // 마커가 위치할 위도와 경도(변수)
               map: map,
               icon: image, // 마커로 사용할 이미지(변수)
//             info: '말풍선 안에 들어갈 내용',
               title: 'NEWEYE 본사' // 마커에 마우스 포인트를 갖다댔을 때 뜨는 타이틀
        });
         
        var content = "NEWEYE 본사"; // 말풍선 안에 들어갈 내용
         
        // 마커를 클릭했을 때의 이벤트. 말풍선 뿅~
        var infowindow = new google.maps.InfoWindow({ content: content});
 
        google.maps.event.addListener(marker, "click", function() {
            infowindow.open(map,marker);
        });
         
 
         
      }
      google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>
<body>

<article>
  <br>
  <br>
  <div id="contract">
    <h2>회사소개</h2><h4>Company Info</h4>
    <img src="img/companyInfo.png"/>
    </div>
    <br><br>
    <center>
   <table style="border: 1px solid red; width:60%; height: 100px; margin: auto; text-align: center;">
   <p style="width: 850px"><span class="strong">뉴아이는</span>광학기기 전문기업 뉴아이의 한국법인으로 2016년에 창립했습니다. 
   창립 이래, 최첨단 디지털 영상기술을 탑재한 제품과 뛰어난 품질의 A/S를 제공함과 동시에, 
   출사, 포토스쿨, 디지털 라이브 쇼, 각종 세미나 등 사진, 영상 문화와 관련된 다양한 활동을 다방면으로 
   전개하여 지난 1년 동안 국내 카메라 산업 발전에 이바지했습니다.</p>
   <p style="width: 850px">니콘이미징코리아는 한 세기 가까이 축적해온 뉴아이만의 광학과 정밀 가공에 관한 기술력을 기반으로 고객에게 풍부한 사진, 영상 생활을 제안함으로써, 고객의 가슴을 뛰게 하는 감동창조 경영에 힘쓰고 있습니다. 또한, 최근 발표한 차세대 프로페셔널 카메라 D5, D500이나 디지털 카메라와 스마트 디바이스를 무선으로 상시 접속할 수 있는 어플리케이션 ‘SnapBridge’ 등 영상 산업의 미래에도 선도적인 역할을 하고 있습니다.</p>
   <p style="width: 850px">앞으로도 광학기기 전문 기업으로서 소명과 책임을 다하고, 국내 긍정적인 사진문화 전파에 기여하고 카메라 대중화를 이끌고자 더욱 노력해 나갈 것입니다.</p>
   </table>
   </center>
   </article>
   <center>
   <table class="tbl_vertical" style="height: 300px">
   <tr>
    <td style="width: 150px" background="">대표이사</td>
    <td>JSP</td>
   </tr>
   <tr>
    <td>설립연도</td>
    <td>2016년</td>
   </tr>
   <tr>
    <td>사업영역</td>
    <td>일안 리플렉스 카메라, 미러리스 카메라, 콤팩트 카메라, 교환렌즈 등 니콘의 영상 관련 제품의 수입,판매 및 서비스에 관한 업무 </td>
   </tr>
   <tr>
    <td>소재지</td>
    <td>대전광역시 중구 중앙로 76 영민빌딩 2층 </td>
   </tr>
   <tr>
    <td>연락처</td>
    <td>042-123-1234</td>
   </tr>
   </table>
   </center>
   <br><br><br>
   
   
<center>
<div id="map-canvas" style="width: 850px; height: 400px"></div>
</center>
<br><br><br><br><br>


</body>

</html>
