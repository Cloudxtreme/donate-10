<%@ include file="/common/taglibs.jsp"%>

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <title><fmt:message key="donationRequestDetail.title"/></title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script>
        $(function() {
            $( "#dtRequired" ).datepicker();
            $( "#dtExpire" ).datepicker();
        });
    </script>
</head>

<body>

<div id="message"></div>
<table>
    <tr>
        <td>
            Donation Required : <input type="text" id="dtRequired">
        </td>
    </tr>
    <tr>
        <td>
            Donation Expire : <input type="text" id="dtExpire">
        </td>
    </tr>
    <tr>
        <td>
            Address : <textarea id="txtAddress" name="txtAddress" rows="10" cols="70"></textarea>
        </td>
    </tr>
    <tr>
        <td>
            Item Name : <input type="text" id="txtItemName" name="txtItemName" />
        </td>
    </tr>
    <tr>
        <td>
            Item Qty : <input type="text" id="txtItemQty" name="txtItemQty" />
        </td>
    </tr>
    <tr><td></td></tr>
    <tr>
        <td>
            <input type="button" id="btnAddRequest" value="Add Request" onclick="submitRequest();" />
            <input type="button" id="btnCompleteRequest" value="Complete Request" onclick="submitCompleteRequest();" />
        </td>
    </tr>
</table>

</div>

<script type="text/javascript">
    $(document).ready(function() {

    });

    function submitCompleteRequest() {
        $.post("/donationRequestform", function() {
            console.log("done");
            $("#message").html("Request Completed!")
        });
    }

    function submitRequest() {
        dateRequired = $("#dtRequired").val();
        dateExpire = $("#dtExpire").val();
        address = $("#txtAddress").val();
        itemName = $("#txtItemName").val();
        itemQty = $("#txtItemQty").val();

        $.post("/donationRequestItemform", {dateRequired: dateRequired, dateExpire: dateExpire,
            address: address, itemName: itemName, itemQty: itemQty}, function() {
            console.log("done");
            $("#dtRequired").val("");
            $("#dtExpire").val("");
            $("#txtAddress").val("");
            $("#txtItemName").val("");
            $("#txtItemQty").val("");

            $("#message").html("Request added!")
        });

    }
</script>
</body>


