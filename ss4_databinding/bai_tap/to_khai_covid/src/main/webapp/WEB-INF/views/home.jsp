<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/5/2022
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h2>TỜ KHAI Y TẾ</h2>
    <h3>TÀI LIỆU QUAN TRỌNG</h3>
    <h4 style="color: red">Khuyến cáo:</h4>
</center>
<div>
    <span>Họ tên (ghi chữ IN HOA)<span style="color: red">(*)</span></span> <br>
    <input type="text" name="name">
</div>
<div>
    <ul>
        <li>
            <span>Năm sinh<span style="color: red">(*)</span></span> <br>
            <input type="number" name="date">
        </li>
        <li>
            <span>Giới tính<span style="color: red">(*)</span></span> <br>
            <select name="gender">
                <option value="none">--Chọn--</option>
                <option value="nam">Nam</option>
                <option value="nu">Nữ</option>
            </select>
        </li>
        <li>
            <span>Quốc Tịch<span style="color: red">(*)</span></span> <br>
            <select name="nation">
                <option value="none">--Chọn--</option>
                <option value="vn">Việt Nam</option>
                <option value="my">Mỹ</option>
            </select>
        </li>
    </ul>
</div>
<div>
    <span>Số hộ chiếu hoặc số cmnd haowcj giấy tờ tuỳ thân<span style="color: red">(*)</span></span>
</div>
<div>
    <span>Thông tin đi lại<span style="color: red">(*)</span></span>
    <div>
        <input type="radio" name="tauBay"><label>Tàu bay</label>
    </div>
    <div>
        <input type="radio" name="tauThuyen"><label>Tàu Thuyền</label>
    </div>
    <div>
        <input type="radio" name="oto"><label>Ô tô</label>
    </div>
    <div>
        <input type="radio" name="khac"><label>Khác</label>
    </div>
</div>
<div>
    <div>
        <span>Sô hiệu phương tiện</span> <br>
        <input type="text" name="bienSo" placeholder="abc-123">
    </div>
    <div>
        <span>Số ghế</span> <br>
        <input type="text" name="soGhe">
    </div>
</div>
<div>
    <div>
        <span>Ngày khởi hành</span> <br>
        <input type="date" name="ngayKhoiHanh">
    </div><div>
        <span>Ngày kkết thúc</span> <br>
        <input type="date" name="ngayKetThuc">
    </div>
</div>
</body>
</html>
