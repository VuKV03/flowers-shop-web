<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý sản phẩm</title>
<link rel="icon" type="image/x-icon" href="./assets/image/image-icons/coll_1_medium.png">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
<link rel="stylesheet" href="./assets/css/manager.css">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
</head>

<body>
	<div class="container">
		<div class="container_header">
			<p>Manage Product</p>
			<div class="form_add">
				<button class="btn-add" id="myBtn">
					<div class="icon-add">
						<i class="fa-solid fa-plus"></i>
					</div>
					<span>Add New Product</span>
				</button>
			</div>
		</div>
		<div class="list_table">
			<table border="1px solid #000" width="100%">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th class="des_product">Description</th>
					<th>Cost Price</th>
					<th>Sale Price</th>
					<th>Image Primary</th>
					<th>Image Secondary</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${listPage}" var="o">
					<tr>
						<td>${o.id}</td>
						<td>${o.name}</td>
						<td>${o.description}</td>
						<td>${o.costPrice}</td>
						<td>${o.salePrice}</td>
						<td><img src="${o.img_primary}" alt=""></td>
						<td><img src="${o.img_second}" alt=""></td>
						<td><a href="loadProduct?pid=${o.id}" title="Edit"><i
								class="fa-solid fa-pen icon-edit"></i></a> <a
							href="delete?pid=${o.id}" title="Delete"><i
								class="fa-solid fa-trash icon-delete"></i></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<div class="paging">
			<c:forEach begin="1" end="${num}" var="i">
				<a href="manage?index=${i}" class="${indexPage == i?"active":""}">${i}</a>
			</c:forEach>
		</div>

		<div class="container_footer">
			<a href="home">
				<button type="button" class="btn-backhome">Back to home</button>
			</a>
		</div>
	</div>

	<!-- modal -->
	<div class="modal" id="myModal">
		<div class="modal-container">
			<form action="add" method="post" enctype="multipart/form-data">
				<div class="modal-header">
					<p>Add Product</p>
					<a href="" class="modal-close"> <i class="fa-solid fa-xmark"></i>
					</a>
				</div>

				<div class="modal-body">
					<div class="row1">
						<div class="row1_col1">
							<label class="modal-label">Name</label> <input name="name"
								type="text" class="modal-input"></input>
						</div>

						<div class="row1_col2">
							<label class="modal-label">Description</label>
							<textarea name="description" id="description" cols="40" rows="4"
								class="modal-textarea"></textarea>
						</div>
					</div>

					<div class="row2">
						<div class="row2_col1">
							<label class="modal-label">Cost Price</label> <input
								name="cost_price" type="text" class="modal-input"></input>
						</div>

						<div class="row2_col2">
							<label class="modal-label">Sale Price</label> <input
								name="sale_price" type="text" class="modal-input"></input>
						</div>
					</div>

					<div class="row3">
						<!--  <div class="row3_col1">
                        <label class="modal-label">Image Primary</label>
                        <input name="image_primary" type="text" class="modal-input"></input>
                    </div>
 -->

						<div class="div1">
							<label class="modal-label">Image Primary</label>
							<div class="hero"
								style="align-items: center; justify-content: center;">
								<div class="card">
									<label
											for="input-file"
<%--											style="display: block; width: 130px; background: #e3362c; color: #fff; padding: 12px; margin: 10px auto; border: 5px; cursor: pointer;"--%>
											class="css-label-img">Upload
										image</label>
									<img src="./assets/img/profile.png" id="profile">
<%--									 <label--%>
<%--										for="input-file"--%>
<%--										style="display: block; width: 130px; background: #e3362c; color: #fff; padding: 12px; margin: 10px auto; border: 5px; cursor: pointer;">Upload--%>
<%--										image</label> --%>
										<input type="file"
										accept="image/jpeg, image/png, image/jpg" name="image_primary"
										id="input-file" style="display: none;" />
								</div>
							</div>
						</div>
						
						<div class="div1">
							<label class="modal-label">Image Secondary</label>
							<div class="hero"
								style="align-items: center; justify-content: center;">
								<div class="card">
									<label
											for="input-file2"
<%--											style="display: block; width: 130px; background: #e3362c; color: #fff; padding: 12px; margin: 10px auto; border: 5px; cursor: pointer;"--%>
											class="css-label-img">Upload
										image</label>
									<img src="./assets/img/profile.png" id="profile2">
<%--									<label--%>
<%--										for="input-file2"--%>
<%--										style="display: block; width: 130px; background: #e3362c; color: #fff; padding: 12px; margin: 10px auto; border: 5px; cursor: pointer;">Upload--%>
<%--										image</label> --%>
									<input type="file"
										accept="image/jpeg, image/png, image/jpg" name="image_secondary"
										id="input-file2" style="display: none;" />
								</div>
							</div>
						</div>


						<!-- <div class="row3_col2">
                        <label class="modal-label">Image Secondary</label>
                        <input name="image_secondary" type="text" class="modal-input"></input>
                    </div> -->
					</div>

					<div class="row4">
						<label class="modal-label">Category</label> <select name="cate"
							id="cate" class="modal-option">
							<c:forEach items="${listC}" var="o">
								<option value="${o.cid}">${o.cname}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="modal-footer">
					<input type="button" id="input-cancel" class="modal-cancel"
						value="Cancel" /> <input type="submit" id="input-add" value="Add" />
				</div>
			</form>
		</div>
	</div>
</body>
<script>
        let profilePic = document.getElementById("profile")
        let inputFile = document.getElementById("input-file");

        inputFile.onchange = function () {
            profilePic.src = URL.createObjectURL(inputFile.files[0]);
        }
        
        let profilePic2 = document.getElementById("profile2")
        let inputFile2 = document.getElementById("input-file2");

        inputFile2.onchange = function () {
            profilePic2.src = URL.createObjectURL(inputFile2.files[0]);
        }
</script>
<script src="./assets/js/manage.js"></script>
</html>
