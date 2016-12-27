<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Index.aspx.cs" Inherits="SheridanBookClubWeb.Index" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Sheridan Book Club</title>
    <link href="Content/bootstrap.min.css" rel="stylesheet" />
    <link href="Content/bootstrap-theme.min.css" rel="stylesheet" />
    <script src="Scripts/jquery-1.9.1.min.js"></script>
    <script src="Scripts/bootstrap.min.js"></script>
</head>
<body>
    <form id="form1" runat="server">
    <div class="container" style="padding: 1%;">
      <h1>Sheridan Book Club</h1><br /><br />
      <asp:Button class="btn btn-success" ID="bookBtn" runat="server" Text="New Book Editor"  width="200px" Height="40px" OnClick="bookBtn_Click" ToolTip="Click to Add New Book" /><br /><br />
      <asp:Button class="btn btn-info" ID="reviewBtn" runat="server" Text="New Review Editor"  width="200px" Height="40px" OnClick="reviewBtn_Click" ToolTip="Click To Add New Review" /><br /><br />
      <asp:Button class="btn btn-warning" ID="viewBtn" runat="server" Text="View Book Review"  width="200px" Height="40px" OnClick="viewBtn_Click" ToolTip="Click To View Reviews" />

    </div>
    </form>
</body>
</html>
