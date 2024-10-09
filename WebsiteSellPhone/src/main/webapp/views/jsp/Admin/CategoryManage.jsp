<%--
  Created by IntelliJ IDEA.
  User: buiquangthuc
  Date: 9/10/24
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Category Manage</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <script src="https://kit.fontawesome.com/27e6f9e8b6.js" crossorigin="anonymous"></script>
    <link href="https://cdn.lineicons.com/4.0/lineicons.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/Admin.css">

</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="wrapper">
            <aside id="sidebar">
                <div class="d-flex">
                    <button class="toggle-btn" type="button">
                        <i class="lni lni-grid-alt"></i>
                    </button>
                    <div class="sidebar-logo">
                        <a href="#">Website Sell Phone</a>
                    </div>
                </div>

                <ul class="sidebar-nav">
                    <li class="sidebar-item">
                        <a href="admin.html" class="sidebar-link">
                            <i class="fa-solid fa-gauge"></i>
                            <span>Dashboard</span>
                        </a>
                    </li>
                    <li class="sidebar-item">
                        <a href="MyStore.html" class="sidebar-link collapsed has-dropdown" data-bs-toggle="collapse"
                           data-bs-target="#subMenu" aria-expanded="false" aria-controls="subMenu">
                            <i class="fa-solid fa-store"></i>
                            <span>My store</span>
                        </a>
                        <ul id="subMenu" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
                            <li>
                                <a href="${pageContext.request.contextPath}/admin/product-manage" class="sidebar-link ms-3">
                                    <i class="fa-solid fa-box"></i>
                                    <span>Product</span>
                                </a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/admin/category-manage" class="sidebar-link ms-3">
                                    <i class="fa-solid fa-tags"></i>
                                    <span>Category</span>
                                </a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/admin/order-manage" class="sidebar-link ms-3">
                                    <i class="fa-solid fa-shopping-cart"></i>
                                    <span>Order</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="sidebar-item">
                        <a href="#" class="sidebar-link">
                            <i class="fa-solid fa-chart-pie"></i>
                            <span>Analytics</span>
                        </a>
                    </li>
                    <li class="sidebar-item">
                        <a href="#" class="sidebar-link">
                            <i class="fa-solid fa-message"></i>
                            <span>Message</span>
                        </a>
                    </li>
                    <li class="sidebar-item">
                        <a href="${pageContext.request.contextPath}/admin/user-manage" class="sidebar-link">
                            <i class="fa-solid fa-people-group"></i>
                            <span>User</span>
                        </a>
                    </li>
                    <li class="sidebar-item">
                        <a href="#" class="sidebar-link">
                            <i class="fa-solid fa-gear"></i>
                            <span>Setting</span>
                        </a>
                    </li>
                </ul>
                <div class="sidebar-footer">
                    <a href="#" class="sidebar-link">
                        <i class="fa-solid fa-right-from-bracket"></i>
                        <span>Log out</span>
                    </a>
                </div>
            </aside>
            <!-- Main Content -->
            <main class="col-md-9 ms-sm-auto col-lg-10 px-md-5">
                <div
                        class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    <h1 class="h2">My store</h1>
                    <div class="btn-toolbar mb-2 mb-md-0">
                        <div class="btn-group me-2">
                            <button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
                            <button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
                        </div>
                        <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
                            <i class="bi bi-calendar"></i> This week
                        </button>
                    </div>
                </div>

                <div class="container-fluid mt-5">
                    <h2 class="text-center">Thống kê danh mục bán chạy</h2>
                    <canvas id="topProductsChart" width="400" height="200"></canvas>
                </div>


                <section id="product-management" class="mb-5">
                    <h2>Category Management</h2>
                    <form class="d-flex float-end" role="search">
                        <input class="form-control me-2" type="search" placeholder="Search Category"
                               aria-label="Search" style="width: 300px;">
                        <button class="btn btn-outline-primary" type="submit">Search</button>

                    </form>
                    <button class="btn btn-primary mb-3" data-bs-toggle="modal"
                            data-bs-target="#addProductModal">Add New Category</button>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Image</th>
                            <th>Name</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>1</td>
                            <td><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRvpQr7jRfGRZXz54j5HdGf6MDP8w5l53a3UQ&s"
                                     alt="" id="icon-category"></td>
                            <td>Apple</td>
                            <td>
                                <button class="btn btn-sm btn-warning">Edit</button>
                                <button class="btn btn-sm btn-danger">Delete</button>
                            </td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td><img src="data:image/png;base64,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"
                                     alt="" id="icon-category"></td>
                            <td>Samsung</td>
                            <td>
                                <button class="btn btn-sm btn-warning">Edit</button>
                                <button class="btn btn-sm btn-danger">Delete</button>
                            </td>
                        </tr>

                        </tbody>
                    </table>
                </section>



            </main>
        </div>
    </div>
</div>

<!-- Modals for Adding Product and Category -->
<!-- Add Product Modal -->
<div class="modal fade" id="addProductModal" tabindex="-1" aria-labelledby="addProductModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addProductModalLabel">Add New Category</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="mb-3">
                        <label for="productName" class="form-label">Category Name</label>
                        <input type="text" class="form-control" id="productName" required>
                    </div>
                    <div class="mb-3">
                        <label for="productCategory" class="form-label">Category</label>
                        <select class="form-select" id="productCategory" required>
                            <option selected>Choose...</option>
                            <option value="1">Smartphones</option>
                            <option value="2">Accessories</option>
                            <!-- More categories here -->
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="productPrice" class="form-label">Price</label>
                        <input type="number" class="form-control" id="productPrice" required>
                    </div>
                    <div class="mb-3">
                        <label for="productStock" class="form-label">Stock</label>
                        <input type="number" class="form-control" id="productStock" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Add Product</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Add Category Modal -->
<div class="modal fade" id="addCategoryModal" tabindex="-1" aria-labelledby="addCategoryModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addCategoryModalLabel">Add New Category</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="mb-3">
                        <label for="categoryName" class="form-label">Category Name</label>
                        <input type="text" class="form-control" id="categoryName" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Add Category</button>
                </form>
            </div>
        </div>
    </div>
</div>



</main>
</div>




</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/views/js/Admin.js"></script>


<script>
    document.addEventListener("DOMContentLoaded", function () {
        const ctx = document.getElementById("topProductsChart").getContext("2d");

        // Dữ liệu ví dụ về tên sản phẩm và số lượng bán
        const productNames = ["Iphone 14", "Samsung s23"];
        const salesData = [150, 100]; // số lượng bán của mỗi sản phẩm

        // Tạo biểu đồ thanh
        const topProductsChart = new Chart(ctx, {
            type: "bar",
            data: {
                labels: productNames,
                datasets: [
                    {
                        label: "Số lượng bán",
                        data: salesData,
                        backgroundColor: "rgba(54, 162, 235, 0.6)", // màu nền thanh biểu đồ
                        borderColor: "rgba(54, 162, 235, 1)", // màu viền thanh biểu đồ
                        borderWidth: 1,
                    },
                ],
            },
            options: {
                responsive: true,
                scales: {
                    y: {
                        beginAtZero: true,
                        title: {
                            display: true,
                            text: "Số lượng",
                        },
                    },
                    x: {
                        title: {
                            display: true,
                            text: "Tên sản phẩm",
                        },
                    },
                },
            },
        });
    });

</script>

</body>

</html>
