<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light shadow-sm">
    <div class="container">
        <!-- Logo -->
        <a class="navbar-brand" href="index.jsp">
            <img src="../images/logo.png" alt="Logo" style="height:50px;">
        </a>
        <!-- Toggle cho mobile -->
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Menu -->
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" href="index.jsp">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="shop.jsp">Cửa hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="about.jsp">Giới thiệu</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contact.jsp">Liên hệ</a>
                </li>
            </ul>

            <!-- User & Cart -->
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0 align-items-center">
                <!-- Login / User -->
                <li class="nav-item me-3">
                    <a class="nav-link" href="login.jsp">
                        <i class="fas fa-user"></i> Đăng nhập
                    </a>
                </li>
                <!-- Cart -->
                <li class="nav-item">
                    <a class="nav-link position-relative" href="cart.jsp">
                        <i class="fas fa-shopping-cart fa-lg"></i>
                        <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                            3
                        </span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- CSS thêm nếu muốn -->
<style>
    .nav-link {
        font-weight: 500;
        margin-right: 15px;
    }
</style>