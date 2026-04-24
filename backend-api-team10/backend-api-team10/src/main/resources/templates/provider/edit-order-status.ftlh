<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Order Status</title>
    <link rel="stylesheet" href="/styles/admin.css">
</head>
<body>
<main class="page-container">
    <a class="utility-back" href="/provider/orders">← Back to Orders</a>

    <div class="section-stack">
        <div class="card">
            <h2>Order #${order.orderId}</h2>
            <div class="meta-list">
                <div><strong>Current Status:</strong> ${order.status!"N/A"}</div>
                <div><strong>Total:</strong> $${order.totalPrice!0}</div>
                <div><strong>Address:</strong> ${order.address!''}</div>
            </div>
        </div>

        <form action="/provider/orders/${order.orderId}/update-status" method="post" class="form-card">
            <div class="form-group">
                <label class="form-label" for="status">New Status</label>
                <select class="form-select" name="status" id="status">
                    <option value="Pending" <#if order.status?? && order.status == "Pending">selected</#if>>Pending</option>
                    <option value="Preparing" <#if order.status?? && order.status == "Preparing">selected</#if>>Preparing</option>
                    <option value="Out for Delivery" <#if order.status?? && order.status == "Out for Delivery">selected</#if>>Out for Delivery</option>
                    <option value="Delivered" <#if order.status?? && order.status == "Delivered">selected</#if>>Delivered</option>
                    <option value="Cancelled" <#if order.status?? && order.status == "Cancelled">selected</#if>>Cancelled</option>
                </select>
            </div>

            <button class="btn btn-cream" type="submit">Save Status</button>
        </form>
    </div>
</main>
</body>
</html>