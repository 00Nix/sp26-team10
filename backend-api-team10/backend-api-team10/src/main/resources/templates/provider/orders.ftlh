<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Orders Dashboard</title>
    <link rel="stylesheet" href="/static/admin.css">
</head>
<body>
    <main class="page-container">
        <a href="/provider/dashboard">← Back to Dashboard</a>
        <h1>Orders Dashboard</h1>

        <#if orders?? && (orders?size > 0)>
            <div class="card-list">
                <#list orders as order>
                    <div class="card">
                        <h2>Order #${order.orderId}</h2>
                        <p><strong>Total:</strong> $${order.totalPrice!0}</p>
                        <p><strong>Status:</strong> ${order.status!"N/A"}</p>
                        <p><strong>Address:</strong> ${order.address!""}</p>
                        <p><strong>Date:</strong> ${order.timestamp!""}</p>

                        <a class="button-link" href="/provider/orders/${order.orderId}/edit">
                            Update Status
                        </a>
                    </div>
                </#list>
            </div>
        <#else>
            <p>No orders found.</p>
        </#if>
    </main>
</body>
</html>