<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="MainForm.aspx.cs" Inherits="ShopMall.MainForm" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>C#: Assignment 3</title>
    <link href="css/mystyle.css" rel="stylesheet" />
    <style type="text/css">
        .auto-style1 {
            width: 284px;
            margin-left: 487px;
        }
        .auto-style2 {
            margin-left: 151px;
        }
    </style>
</head>
<body style="height: 317px">
    <form id="form1" runat="server">
        <div class="div-style1">
            <h2>Boxing Day Sale, Hot Deal, Best Cell Phone ! </h2>
        </div>
        <div class="div-style2">
            <asp:ImageButton class="phoneImg" ID="ImageButton1" runat="server" Height="161px" AlternateText="Image text"
                ImageAlign="middle" ImageUrl="images/cPhone0.jpg" OnClick="ImageButton1_Click" Width="160px" AccessKey="0" ToolTip="Click This Image to View Detail Information"/>
            <asp:ImageButton class="phoneImg" ID="ImageButton2" runat="server" Height="160px" AlternateText="Image text"
                ImageAlign="middle" ImageUrl="images/cPhone1.jpg" Width="160px" OnClick="ImageButton2_Click" AccessKey="1" ToolTip="Click This Image to View Detail Information"/>
            <asp:ImageButton class="phoneImg" ID="ImageButton3" runat="server" Height="160px" AlternateText="Image text"
                ImageAlign="middle" ImageUrl="images/cPhone2.jpg" Width="160px" OnClick="ImageButton3_Click" AccessKey="2" ToolTip="Click This Image to View Detail Information"/>
        </div>
        <div class="auto-style1">
            <asp:Button ID="adminBtn" runat="server" Text="Admin Login" OnClick="adminBtn_Click" CssClass="auto-style2" Height="30px" Width="131px" ToolTip="Only Permitted to Administrator" />
        </div>
    </form>
</body>
</html>
