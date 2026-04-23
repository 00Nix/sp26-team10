<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Order Status</title>
    <link rel="stylesheet" href="/static/admin.css">
</head>
<body>
    <main class="page-container">
        <a href="/provider/orders">← Back to Orders</a>
        <h1>Update Order Status</h1>

        <div class="card">
            <p><strong>Order ID:</strong> ${order.orderId}</p>
            <p><strong>Current Status:</strong> ${order.status!"N/A"}</p>
            <p><strong>Total:</strong> $${order.totalPrice!0}</p>
        </div>

        <form action="/provider/orders/${order.orderId}/update-status" method="post" class="form-card">
            <label for="status">New Status</label>
            <select name="status" id="status">
                <option value="Pending" <#if order.status?? && order.status == "Pending">selected</#if>>Pending</option>
                <option value="Preparing" <#if order.status?? && order.status == "Preparing">selected</#if>>Preparing</option>
                <option value="Out for Delivery" <#if order.status?? && order.status == "Out for Delivery">selected</#if>>Out for Delivery</option>
                <option value="Delivered" <#if order.status?? && order.status == "Delivered">selected</#if>>Delivered</option>
                <option value="Cancelled" <#if order.status?? && order.status == "Cancelled">selected</#if>>Cancelled</option>
            </select>

            <button type="submit">Save Status</button>
        </form>
    </main>
</body>
</html>