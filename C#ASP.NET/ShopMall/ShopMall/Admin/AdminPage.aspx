<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="AdminPage.aspx.cs" Inherits="ShopMall.Admin.AdminPage" %>

<%@ Register assembly="System.Web.DataVisualization, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35" namespace="System.Web.UI.DataVisualization.Charting" tagprefix="asp" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            margin-left: 0px;
        }
        .auto-style2 {
            height: 40px;
            margin-left: 48px;
        }
        .auto-style3 {
            height: 361px;
            width: 770px;
            margin-left: 16px;
        }
        .auto-style4 {
            margin-left: 43px;
        }
        .auto-style5 {
            margin-left: 46px;
        }
        .auto-style6 {
            margin-left: 31px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <br />
        <br />
        <asp:Button ID="goBtn3" runat="server" CssClass="auto-style5" Height="40px" OnClick="goBtn3_Click" Text="Go to Shopping" Width="333px" /><br /><br /><br />
        <h3>[ Sale Information ]</h3>
        <div class="auto-style1">
            <asp:GridView ID="saleGV" runat="server" Height="148px" Width="562px" AllowPaging="True" AllowSorting="True" AutoGenerateColumns="False" BackColor="White" BorderColor="#999999" BorderStyle="None" BorderWidth="1px" CellPadding="3" CssClass="auto-style4" DataKeyNames="Id" DataSourceID="SqlDataSource2" GridLines="Vertical">
                <AlternatingRowStyle BackColor="#DCDCDC" />
                <Columns>
                    <asp:CommandField ShowDeleteButton="True" ShowEditButton="True" />
                    <asp:BoundField DataField="Id" HeaderText="Id" InsertVisible="False" ReadOnly="True" SortExpression="Id" />
                    <asp:BoundField DataField="ProductId" HeaderText="ProductId" SortExpression="ProductId" />
                    <asp:BoundField DataField="Quantity" HeaderText="Quantity" SortExpression="Quantity" />
                    <asp:BoundField DataField="Price" HeaderText="Price" SortExpression="Price" />
                </Columns>
                <FooterStyle BackColor="#CCCCCC" ForeColor="Black" />
                <HeaderStyle BackColor="#000084" Font-Bold="True" ForeColor="White" />
                <PagerStyle BackColor="#999999" ForeColor="Black" HorizontalAlign="Center" />
                <RowStyle BackColor="#EEEEEE" ForeColor="Black" />
                <SelectedRowStyle BackColor="#008A8C" Font-Bold="True" ForeColor="White" />
                <SortedAscendingCellStyle BackColor="#F1F1F1" />
                <SortedAscendingHeaderStyle BackColor="#0000A9" />
                <SortedDescendingCellStyle BackColor="#CAC9C9" />
                <SortedDescendingHeaderStyle BackColor="#000065" />
            </asp:GridView>
            <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:ProductsConnectionString %>" DeleteCommand="DELETE FROM [Rating] WHERE [Id] = @Id" InsertCommand="INSERT INTO [Rating] ([ProductId], [ProductRating], [Comment]) VALUES (@ProductId, @ProductRating, @Comment)" SelectCommand="SELECT * FROM [Rating]" UpdateCommand="UPDATE [Rating] SET [ProductId] = @ProductId, [ProductRating] = @ProductRating, [Comment] = @Comment WHERE [Id] = @Id">
                <DeleteParameters>
                    <asp:Parameter Name="Id" Type="Int32" />
                </DeleteParameters>
                <InsertParameters>
                    <asp:Parameter Name="ProductId" Type="Int32" />
                    <asp:Parameter Name="ProductRating" Type="Int32" />
                    <asp:Parameter Name="Comment" Type="String" />
                </InsertParameters>
                <UpdateParameters>
                    <asp:Parameter Name="ProductId" Type="Int32" />
                    <asp:Parameter Name="ProductRating" Type="Int32" />
                    <asp:Parameter Name="Comment" Type="String" />
                    <asp:Parameter Name="Id" Type="Int32" />
                </UpdateParameters>
            </asp:SqlDataSource>
        </div><br /><br />
        <div>
            <asp:Chart ID="saleCH" runat="server" Height="341px" Width="634px" CssClass="auto-style1" DataSourceID="SqlDataSource2">
                <series>
                    <asp:Series Name="Series1" XValueMember="ProductId" YValueType="Int64" YValueMembers="Quantity" YValuesPerPoint="1">
                    </asp:Series>
                </series>
                <chartareas>
                    <asp:ChartArea Name="ChartArea1">
                        <AxisY Title="Max per Sold Product">
                        </AxisY>
                        <AxisX Title="Product ID" IsLabelAutoFit="True">
                            <LabelStyle Angle="-90" Interval="1" />
                        </AxisX>
                    </asp:ChartArea>
                </chartareas>
            </asp:Chart><br />
            <br /><br /><br />
        </div>
        <div class="auto-style2">
            <asp:SqlDataSource ID="SqlDataSource2" runat="server" ConnectionString="<%$ ConnectionStrings:ProductsConnectionString %>" DeleteCommand="DELETE FROM [Sales] WHERE [Id] = @Id" InsertCommand="INSERT INTO [Sales] ([ProductId], [Quantity], [Price]) VALUES (@ProductId, @Quantity, @Price)" SelectCommand="SELECT * FROM [Sales]" UpdateCommand="UPDATE [Sales] SET [ProductId] = @ProductId, [Quantity] = @Quantity, [Price] = @Price WHERE [Id] = @Id">
                <DeleteParameters>
                    <asp:Parameter Name="Id" Type="Int32" />
                </DeleteParameters>
                <InsertParameters>
                    <asp:Parameter Name="ProductId" Type="Int32" />
                    <asp:Parameter Name="Quantity" Type="Int32" />
                    <asp:Parameter Name="Price" Type="Decimal" />
                </InsertParameters>
                <UpdateParameters>
                    <asp:Parameter Name="ProductId" Type="Int32" />
                    <asp:Parameter Name="Quantity" Type="Int32" />
                    <asp:Parameter Name="Price" Type="Decimal" />
                    <asp:Parameter Name="Id" Type="Int32" />
                </UpdateParameters>
            </asp:SqlDataSource>
        </div><br />
        <h3>[ Rating Information ]</h3>
        <div class="auto-style3">
            <asp:GridView ID="rateGV" runat="server" Height="153px" Width="562px" AllowPaging="True" AllowSorting="True" AutoGenerateColumns="False" BackColor="White" BorderColor="#3366CC" BorderStyle="None" BorderWidth="1px" CellPadding="4" DataKeyNames="Id" DataSourceID="SqlDataSource1" CssClass="auto-style6">
                <Columns>
                    <asp:CommandField ShowDeleteButton="True" ShowEditButton="True" />
                    <asp:BoundField DataField="Id" HeaderText="Id" InsertVisible="False" ReadOnly="True" SortExpression="Id" />
                    <asp:BoundField DataField="ProductId" HeaderText="ProductId" SortExpression="ProductId" />
                    <asp:BoundField DataField="ProductRating" HeaderText="ProductRating" SortExpression="ProductRating" />
                    <asp:BoundField DataField="Comment" HeaderText="Comment" SortExpression="Comment" />
                </Columns>
                <FooterStyle BackColor="#99CCCC" ForeColor="#003399" />
                <HeaderStyle BackColor="#003399" Font-Bold="True" ForeColor="#CCCCFF" />
                <PagerStyle BackColor="#99CCCC" ForeColor="#003399" HorizontalAlign="Left" />
                <RowStyle BackColor="White" ForeColor="#003399" />
                <SelectedRowStyle BackColor="#009999" Font-Bold="True" ForeColor="#CCFF99" />
                <SortedAscendingCellStyle BackColor="#EDF6F6" />
                <SortedAscendingHeaderStyle BackColor="#0D4AC4" />
                <SortedDescendingCellStyle BackColor="#D6DFDF" />
                <SortedDescendingHeaderStyle BackColor="#002876" />
            </asp:GridView><br /><br />
            <div>
            <asp:Chart ID="rateCH" runat="server" Height="339px" Width="619px" CssClass="auto-style4" DataSourceID="SqlDataSource1">
                <Series>
                    <asp:Series Name="Series1" ChartArea="ChartArea1" ChartType="Pie" XValueMember="ProductId" YValueMembers="ProductRating"></asp:Series>
                </Series>
                <ChartAreas>
                    <asp:ChartArea Name="ChartArea1"  BorderColor="DarkGray"></asp:ChartArea>
                </ChartAreas>
                <Legends>
                    <asp:Legend Name="Legend1" Title="Rating Percentage of Product ">
                    </asp:Legend>
                </Legends>
                <Titles>
                    <asp:Title BackColor="Snow" Name="Sales Pie Chart">
                    </asp:Title>
                </Titles>
            </asp:Chart>
            </div><br />
        </div>
    </form>
</body>
</html>
