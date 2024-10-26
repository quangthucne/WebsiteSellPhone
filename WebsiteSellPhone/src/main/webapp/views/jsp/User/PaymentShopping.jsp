<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/Payment.css">
</head>
<body>
	<div class="page-header">
        <h2>Thanh Toán</h2>
    </div>

    <div class="container mt-5">
        <div class="row">
            <div class="col-md-8">
                <div class="form-section">
                    <h5>Thông Tin Thanh Toán</h5>
                    <form>
                        <div class="row g-3">
                            <div class="col-md-6">
                                <label for="firstName" class="form-label">Tên</label>
                                <input type="text" class="form-control" id="firstName" required>
                            </div>
                            <div class="col-md-6">
                                <label for="lastName" class="form-label">Họ</label>
                                <input type="text" class="form-control" id="lastName" required>
                            </div>
                            <div class="col-12">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" class="form-control" id="email" required>
                            </div>
                            <div class="col-12">
                                <label for="address" class="form-label">Địa Chỉ</label>
                                <select class="form-select" id="address" required>
                                    <option selected disabled>Chọn địa chỉ của bạn</option>
                                    <option value="address1">123 Đường A, Quận 1, TP. Hồ Chí Minh</option>
                                    <option value="address2">456 Đường B, Quận 2, TP. Hồ Chí Minh</option>
                                    <option value="address3">789 Đường C, Quận 3, TP. Hồ Chí Minh</option>
                                </select>
                            </div>
                        </div>
                    </form>
                </div>

                <div class="form-section">
                    <h5>Phương Thức Thanh Toán</h5>
                    <form>
                        <div class="form-check mb-2">
                            <input class="form-check-input" type="radio" name="paymentMethod" id="paymentCard" value="card" required>
                            <label class="form-check-label" for="paymentCard">Thanh toán bằng VNPAY</label>
                        </div>
                        <div class="form-check mb-4">
                            <input class="form-check-input" type="radio" name="paymentMethod" id="paymentCOD" value="cod">
                            <label class="form-check-label" for="paymentCOD">Thanh toán khi nhận hàng (COD)</label>
                        </div>

                        <div id="cardDetails" style="display: none;">
                            <h5>Chi Tiết Thanh Toán Thẻ</h5>
                            <div class="mb-3">
                                <label for="cardName" class="form-label">Tên Trên Thẻ</label>
                                <input type="text" class="form-control" id="cardName">
                            </div>
                            <div class="mb-3">
                                <label for="cardNumber" class="form-label">Số Thẻ</label>
                                <input type="text" class="form-control" id="cardNumber">
                            </div>
                            <div class="row g-3">
                                <div class="col-md-6">
                                    <label for="expDate" class="form-label">Ngày Hết Hạn</label>
                                    <input type="text" class="form-control" id="expDate" placeholder="MM/YY">
                                </div>
                                <div class="col-md-6">
                                    <label for="cvv" class="form-label">CVV</label>
                                    <input type="text" class="form-control" id="cvv">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <div class="col-md-4">
                <div class="order-summary">
                    <h5>Tóm Tắt Đơn Hàng</h5>
                    <div class="d-flex justify-content-between">
                        <span>Sản phẩm:</span>
                        <span>29.990.000 ₫</span>
                    </div>
                    <div class="d-flex justify-content-between">
                        <span>Phí Vận Chuyển:</span>
                        <span>0 ₫</span>
                    </div>
                    <div class="d-flex justify-content-between">
                        <span>Giảm Giá:</span>
                        <span>-4.000.000 ₫</span>
                    </div>
                    <hr>
                    <div class="d-flex justify-content-between order-total">
                        <span>Tổng Cộng:</span>
                        <span>25.990.000 ₫</span>
                    </div>
                    <button type="button" class="btn btn-pay mt-3">Thanh Toán</button>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    <script>
        document.getElementById('paymentCard').addEventListener('change', function () {
            document.getElementById('cardDetails').style.display = 'block';
        });

        document.getElementById('paymentCOD').addEventListener('change', function () {
            document.getElementById('cardDetails').style.display = 'none';
        });
    </script>
</body>
</html>