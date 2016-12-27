<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ProductForm.aspx.cs" Inherits="ShopMall.ProductForm" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Product Page</title>
    <link href="css/mystyle.css" rel="stylesheet" />
    <style type="text/css">
        .auto-style1 {
            width: 97%;
            margin-left: 21px;
        }
        .auto-style5 {
            width: 228px;
        }
        .auto-style6 {
            width: 314px;
        }
        .auto-style7 {
            width: 282px;
        }
        .auto-style8 {
            width: 140px;
        }
        .auto-style10 {
            width: 146px;
        }
        .auto-style11 {
            margin-left: 0px;
        }
        .auto-style12 {
            margin: 2% 2% 0% 2%;
            float: left;
            height: 214px;
        }
        .auto-style13 {
            height: 206px;
            width: 203px;
        }
        .auto-style14 {
            margin-top: 0px;
        }
        .auto-style15 {
            margin-top: 1.5%;
            height: 203px;
        }
        .auto-style16 {
            height: 471px;
            margin-bottom: 76px;
            width: 816px;
        }
        .auto-style17 {
            width: 98%;
            margin-left: 17px;
        }
        .auto-style18 {
            width: 87px;
        }
        .auto-style19 {
            margin-left: 1px;
        }
        .auto-style20 {
            text-align: center;
            color: blue;
            font-size: 13px;
            font-weight: bold;
            padding: 0;
            width: 786px;
            height: 73px;
            margin-left:20px;
        }
        .auto-style21 {
            text-align: center;
            color: blue;
            font-size: 13px;
            font-weight: bold;
            padding: 0;
            width: 786px;
            margin-left:20px;
            height: 78px;
        }
        .auto-style22 {
            margin-left: 43px;
        }
        .auto-style23 {
            margin-left: 20px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server" class="auto-style16">
        <h3>[ Product Information ]</h3>
        <div style="background-color: chartreuse;" class="auto-style23">
          <div class="auto-style12" >
            <img alt="Sale Phone" id="phoneImage" src="Images/cPhone1.jpg" runat="server" class="auto-style13"/>
          </div><br />
          <div class="auto-style15">
            <asp:Label ID="Label1" runat="server" Text="Product ID" Width="150px" Height="15px"></asp:Label>
            <asp:TextBox ID="TextBox1" runat="server" Width="100px" Enabled="False" Height="15px"></asp:TextBox>
            <br /><br />
            <asp:Label ID="Label2" runat="server" Text="Name" Width="150px" Height="30px"></asp:Label>
            <asp:TextBox ID="TextBox2" runat="server" Width="379px" Enabled="False" TextMode="MultiLine" Height="30px"></asp:TextBox>
            <br /><br />
            <asp:Label ID="Label3" runat="server" Text="Price(CD$)" Width="150px" Height="15px"></asp:Label>
            <asp:TextBox ID="TextBox3" runat="server" Width="100px" Enabled="False" Height="15px"></asp:TextBox>
            <br /><br />
            <asp:Label ID="Label4" runat="server" Text="Specification" Width="150px" CssClass="auto-style14" Height="50px"></asp:Label>
            <asp:TextBox ID="TextBox4" runat="server" Width="379px" Enabled="False" TextMode="MultiLine" Height="50px"></asp:TextBox>
          </div><br /><br />
        </div>
        <h3>[ Shopping Cart To Order ]</h3>
        <div class="auto-style20" style="background-color: aqua;">
            <table class="auto-style17">
                <tr>
                    <th class="auto-style7">
                        <asp:Label ID="Label5" runat="server" Text="Product"></asp:Label>
                    </th>
                    <th class="auto-style6">
                        <asp:Label ID="Label6" runat="server" Text="Quantity"></asp:Label>
                    </th>
                    <th class="auto-style5">
                        <asp:Label ID="Label7" runat="server" Text="Total Price(CD$)"></asp:Label>
                    </th>
                    <th>
                        <asp:Label ID="Label8" runat="server" Text="Add to Cart"></asp:Label>
                    </th>
                </tr>
                <tr>
                    <td class="auto-style7">
                        <asp:TextBox ID="sesName" runat="server" Enabled="False" Width="353px" Height="30px" TextMode="MultiLine"></asp:TextBox>
                    </td>
                    <td class="auto-style6">
                        <asp:DropDownList ID="sesQu" runat="server" Height="30px" Width="83px" OnSelectedIndexChanged="sesQu_SelectedIndexChanged" AutoPostBack="True" ToolTip="Select The Number What You Want">
                            <asp:ListItem Value="1" Selected="True"></asp:ListItem>
                            <asp:ListItem Value="2"></asp:ListItem>
                            <asp:ListItem Value="3"></asp:ListItem>
                            <asp:ListItem Value="4"></asp:ListItem>
                            <asp:ListItem Value="5"></asp:ListItem>
                            <asp:ListItem Value="6"></asp:ListItem>
                        </asp:DropDownList>
                    </td>
                    <td class="auto-style5">
                        <asp:TextBox ID="sesPr" runat="server" Enabled="False" Height="30px"></asp:TextBox>
                    </td>
                    <td>
                        <asp:Button ID="sesAd" runat="server" Text="Add" Width="85px" OnClick="sesAd_Click" Height="30px" ToolTip="Click If You Want To Put It Into Shopping Cart  " />
                    </td>
                </tr>
            </table>
        </div><br />
        <h3>[ Comment and Question ]</h3>
        <div class="auto-style21" style="background-color: orange;">
            <table class="auto-style1">
                <tr>
                    <th class="auto-style10">
                        <asp:Label ID="Label11" runat="server" Text="Questions/Comments"></asp:Label>
                    </th>
                    <th class="auto-style8">
                        <asp:Label ID="Label10" runat="server" Text="Rating"></asp:Label>
                    </th>
                    <th class="auto-style18">
                        <asp:Label ID="Label12" runat="server" Text="Register"></asp:Label>
                    </th>
                </tr>
                <tr>
                    <td class="auto-style10">
                        <asp:TextBox ID="comText" runat="server" CssClass="auto-style11" Width="523px" Height="39px" TextMode="MultiLine" ToolTip="Edit Your Comment Or Question About This Cell Phone "></asp:TextBox>
                    </td>
                    <td class="auto-style8">
                        <asp:DropDownList ID="rateText" runat="server" Height="30px" Width="107px" OnSelectedIndexChanged="sesQu_SelectedIndexChanged" AutoPostBack="True" CssClass="auto-style19" ToolTip="Make Your Rate for This Product ">
                            <asp:ListItem Value="1"></asp:ListItem>
                            <asp:ListItem Value="2"></asp:ListItem>
                            <asp:ListItem Value="3" Selected="True"></asp:ListItem>
                            <asp:ListItem Value="4"></asp:ListItem>
                            <asp:ListItem Value="5"></asp:ListItem>
                        </asp:DropDownList>
                    </td>
                    <td class="auto-style18">
                        <asp:Button ID="sendBtn" runat="server" Text="Send" Width="85px" OnClick="sendBtn_Click" Height="30px" ToolTip="Click to Save Your Comment Or Question" />
                    </td>
                </tr>
            </table>
        </div><br />
        <div class="auto-style22">
            <asp:Button ID="homeBtn" runat="server" Text="Continue Shopping" OnClick="homeBtn_Click" ToolTip="Click to Continue Shopping" /><asp:Label ID="Label9" runat="server" Text="" Width="10px"></asp:Label>
            <asp:Button ID="cartBtn" runat="server" Text="Go to Shopping Cart" OnClick="cartBtn_Click" ToolTip="Click to Go ToShopping Cart" />
        </div>
    </form>
</body>
</html>
