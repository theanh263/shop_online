/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.43
 * Generated at: 2021-05-11 13:23:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class detail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("/common/taglib.jsp", Long.valueOf(1620140778383L));
    _jspx_dependants.put("jar:file:/C:/Users/THEAN/online_shop_1/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/shoponline/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1620142422658L));
    _jspx_dependants.put("jar:file:/C:/Users/THEAN/online_shop_1/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/shoponline/WEB-INF/lib/sitemesh-2.4.2.jar!/META-INF/sitemesh-decorator.tld", Long.valueOf(1123645892000L));
    _jspx_dependants.put("/WEB-INF/lib/sitemesh-2.4.2.jar", Long.valueOf(1620142422779L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\t<!DOCTYPE html>\r\n");
      out.write("\t\t<html>\r\n");
      out.write("\r\n");
      out.write("\t\t<head>\r\n");
      out.write("\t\t\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t\t\t<title>Chi tiết sản phẩm</title>\r\n");
      out.write("\t\t</head>\r\n");
      out.write("\r\n");
      out.write("\t\t<body>\r\n");
      out.write("\t\t\t<!-- BODY -->\r\n");
      out.write("\t\t\t<div id='detail-page'>\r\n");
      out.write("\t\t\t\t<div class='container'>\r\n");
      out.write("\t\t\t\t\t<div class=\"detail-container\">\r\n");
      out.write("\t\t\t\t\t\t<nav aria-label=\"breadcrumb\">\r\n");
      out.write("\t\t\t\t\t\t\t<ol class=\"breadcrumb\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"breadcrumb-item\"><a href=\"#\">Home</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- \t\t\t\t\t\t<li class=\"breadcrumb-item\"><a href=\"#\">Library</a></li> -->\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"breadcrumb-item active\" aria-current=\"page\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</li>\r\n");
      out.write("\t\t\t\t\t\t\t</ol>\r\n");
      out.write("\t\t\t\t\t\t</nav>\r\n");
      out.write("\t\t\t\t\t\t<div class='detail-body'>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"main-info\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"image-container\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<img src=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" alt='' />\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"main-info-detail\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<h1 class='detail-title'>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h1>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<!-- \t\t\t\t\t\t\t<h5 class='detail-code'>\r\n");
      out.write("\t\t\t\t\t\t\t\tItem code: <i>MH370MALAYSIAAIRLINE</i>\r\n");
      out.write("\t\t\t\t\t\t\t</h5> -->\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<h5 class='detail-producer'>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tProducer: <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.producer }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<h5 class='detail-producer'>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tStock: <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.stock }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.price }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" WON</h3>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<button title='Add to cart'>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"fas fa-shopping-cart\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<form id=\"formSubmit\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"productId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.id  }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"quantity\" value=\"1\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"userId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${USERMODEL.id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"userName\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${USERMODEL.userName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"productName\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.title   }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<button type=\"submit\" id=\"btnBuy\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tQuick buy</i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"description\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<hr />\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class='desc-container'>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.description}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<script>\r\n");
      out.write("\t\t\t\t$('#btnBuy').click(function (e) {\r\n");
      out.write("\t\t\t\t\te.preventDefault();\r\n");
      out.write("\t\t\t\t\tvar data = {};\r\n");
      out.write("\t\t\t\t\tvar formData = $('#formSubmit').serializeArray();\r\n");
      out.write("\t\t\t\t\t$.each(formData, function (i, v) {\r\n");
      out.write("\t\t\t\t\t\tdata[\"\" + v.name + \"\"] = v.value;\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\taddProduct(data);\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\tfunction addProduct(data) {\r\n");
      out.write("\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\turl: \"/myproducts\",\r\n");
      out.write("\t\t\t\t\t\ttype: 'POST',\r\n");
      out.write("\t\t\t\t\t\tcontentType: 'application/json',\r\n");
      out.write("\t\t\t\t\t\tdata: JSON.stringify(data),\r\n");
      out.write("\t\t\t\t\t\tdataType: 'json',\r\n");
      out.write("\t\t\t\t\t\tsuccess: function (result) {\r\n");
      out.write("\t\t\t\t\t\t\twindow.location.href = \"/myproducts?userCart=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${USERMODEL.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\terror: function (error) {\r\n");
      out.write("\t\t\t\t\t\t\twindow.location.href = \"/trang-chu\";\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t</body>\r\n");
      out.write("\r\n");
      out.write("\t\t</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f0_reused = false;
    try {
      _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f0.setParent(null);
      // /views/web/detail.jsp(26,19) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f0.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.thumbnail }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
      if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      _jspx_th_c_005furl_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f0, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f0_reused);
    }
    return false;
  }
}