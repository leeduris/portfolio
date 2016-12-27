using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(ShopMall.Startup))]
namespace ShopMall
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
