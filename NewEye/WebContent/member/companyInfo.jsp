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
        var mapLocation = new google.maps.LatLng('36.325054', ' 127.420061'); // �������� ����� ��ġ�� ������ �浵
        var markLocation = new google.maps.LatLng('36.325054', ' 127.420061'); // ��Ŀ�� ��ġ�� ������ �浵
         
        var mapOptions = {
          center: mapLocation, // �������� ����� ��ġ�� ������ �浵(����)
          zoom: 18, // ���� zoom�ܰ�
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById("map-canvas"), // id: map-canvas, body�� �ִ� div�±��� id�� ���ƾ� ��
            mapOptions);
         
        var size_x = 60; // ��Ŀ�� ����� �̹����� ���� ũ��
        var size_y = 60; // ��Ŀ�� ����� �̹����� ���� ũ��
         
        // ��Ŀ�� ����� �̹��� �ּ�
        var image = new google.maps.MarkerImage( 'http://www.larva.re.kr/home/img/boximage3.png',
                            new google.maps.Size(size_x, size_y),
                            '',
                            '',
                            new google.maps.Size(size_x, size_y));
         
        var marker;
        marker = new google.maps.Marker({
               position: markLocation, // ��Ŀ�� ��ġ�� ������ �浵(����)
               map: map,
               icon: image, // ��Ŀ�� ����� �̹���(����)
//             info: '��ǳ�� �ȿ� �� ����',
               title: 'NEWEYE ����' // ��Ŀ�� ���콺 ����Ʈ�� ���ٴ��� �� �ߴ� Ÿ��Ʋ
        });
         
        var content = "NEWEYE ����"; // ��ǳ�� �ȿ� �� ����
         
        // ��Ŀ�� Ŭ������ ���� �̺�Ʈ. ��ǳ�� ��~
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
    <h2>ȸ��Ұ�</h2><h4>Company Info</h4>
    <img src="img/companyInfo.png"/>
    </div>
    <br><br>
    <center>
   <table style="border: 1px solid red; width:60%; height: 100px; margin: auto; text-align: center;">
   <p style="width: 850px"><span class="strong">�����̴�</span>���б�� ������� �������� �ѱ��������� 2016�⿡ â���߽��ϴ�. 
   â�� �̷�, ��÷�� ������ �������� ž���� ��ǰ�� �پ ǰ���� A/S�� �����԰� ���ÿ�, 
   ���, ���佺��, ������ ���̺� ��, ���� ���̳� �� ����, ���� ��ȭ�� ���õ� �پ��� Ȱ���� �ٹ������ 
   �����Ͽ� ���� 1�� ���� ���� ī�޶� ��� ������ �̹����߽��ϴ�.</p>
   <p style="width: 850px">�����̹�¡�ڸ��ƴ� �� ���� ������ �����ؿ� �����̸��� ���а� ���� ������ ���� ������� ������� ������ ǳ���� ����, ���� ��Ȱ�� ���������ν�, ���� ������ �ٰ� �ϴ� ����â�� �濵�� ������ �ֽ��ϴ�. ����, �ֱ� ��ǥ�� ������ ������ų� ī�޶� D5, D500�̳� ������ ī�޶�� ����Ʈ ����̽��� �������� ��� ������ �� �ִ� ���ø����̼� ��SnapBridge�� �� ���� ����� �̷����� �������� ������ �ϰ� �ֽ��ϴ�.</p>
   <p style="width: 850px">�����ε� ���б�� ���� ������μ� �Ҹ�� å���� ���ϰ�, ���� �������� ������ȭ ���Ŀ� �⿩�ϰ� ī�޶� ����ȭ�� �̲����� ���� ����� ���� ���Դϴ�.</p>
   </table>
   </center>
   </article>
   <center>
   <table class="tbl_vertical" style="height: 300px">
   <tr>
    <td style="width: 150px" background="">��ǥ�̻�</td>
    <td>JSP</td>
   </tr>
   <tr>
    <td>��������</td>
    <td>2016��</td>
   </tr>
   <tr>
    <td>�������</td>
    <td>�Ͼ� ���÷��� ī�޶�, �̷����� ī�޶�, ����Ʈ ī�޶�, ��ȯ���� �� ������ ���� ���� ��ǰ�� ����,�Ǹ� �� ���񽺿� ���� ���� </td>
   </tr>
   <tr>
    <td>������</td>
    <td>���������� �߱� �߾ӷ� 76 ���κ��� 2�� </td>
   </tr>
   <tr>
    <td>����ó</td>
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
