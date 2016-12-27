<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ShoppingCart.aspx.cs" Inherits="ShopMall.ShoppingCart" EnableEventValidation="false" %>

 <!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            margin-left: 64px;
        }
        .auto-style2 {
            margin-left: 67px;
            width: 928px;
            height: 463px;
            margin-top: 32px;
        }
        .auto-style3 {
            margin-left: 16px;
            margin-top: 13px;
        }
    </style>
</head>
<body style="margin-bottom: 38px">
    <form id="form1" runat="server">
    <div class="auto-style2">
        <asp:GridView ID="GridView1" runat="server" BackColor="#CCCCCC" BorderColor="#999999" BorderStyle="Solid" BorderWidth="3px" CellPadding="4" CellSpacing="2" ForeColor="Black" Width="900px"
            EmptyDataText="Your Card is Emply, Continue Shopping !"
            AllowPaging="True"
            OnRowDeleting="GridView1_RowDeleting"
            OnRowUpdating="GridView1_RowUpdating"
            OnRowEditing="GridView1_RowEditing"
            OnRowCancelingEdit="GridView1_RowCancelingEdit" CssClass="auto-style3">
            <Columns>
                <asp:CommandField ButtonType="Button" ShowDeleteButton="True" />
            </Columns>
            <EmptyDataRowStyle BackColor="#CCFFCC" BorderColor="#FF6600" />
            <FooterStyle BackColor="#CCCCCC" />
            <HeaderStyle BackColor="Black" Font-Bold="True" ForeColor="White" />
            <PagerStyle BackColor="#CCCCCC" ForeColor="Black" HorizontalAlign="Left" />
            <RowStyle BackColor="White" />
            <SelectedRowStyle BackColor="#000099" Font-Bold="True" ForeColor="White" />
            <SortedAscendingCellStyle BackColor="#F1F1F1" />
            <SortedAscendingHeaderStyle BackColor="#808080" />
            <SortedDescendingCellStyle BackColor="#CAC9C9" />
            <SortedDescendingHeaderStyle BackColor="#383838" />
        </asp:GridView>
        <br />
        <br />
    </div>
    <div class="auto-style1">
        <asp:Button ID="buyBtn" runat="server" Text="PURCHASE" OnClick="buyBtn_Click" ToolTip="Click To Buy Shopping Card List" />
        <asp:Label ID="Label1" runat="server" Text="" Width="60px"></asp:Label>
        <asp:Button ID="homeBtn2" runat="server" OnClick="homeBtn2_Click" Text="Continue Shopping" ToolTip="Click To go Shooping List" />
    </div><br /><br />
    </form>
</body>
</html>
