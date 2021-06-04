package shoponline.com.shoponline.controller.admin;

//Import required java libraries
import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import shoponline.com.shoponline.service.admin.IProductService;

@WebServlet(urlPatterns = {"/admin-picProduct"})
public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 2602212086063826992L;
	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 500 * 1024; 
	private int maxMemSize = 4 * 1024;
	private File file;
	@Inject
	private IProductService productService;

	public void init() {
		// Get the file location where it would be stored.
		filePath = getServletContext().getInitParameter("file-upload");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		String productid = request.getParameter("productid");
		// Check that we have a file upload request
		isMultipart = ServletFileUpload.isMultipartContent(request);
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();

		if (!isMultipart) {
			out.println("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\r\n"
					+ "	pageEncoding=\"UTF-8\"%>\r\n"
					+ "<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet upload</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<p>No file uploaded</p>");
			out.println("</body>");
			out.println("</html>");
			return;
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();

		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);

		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File("c:\\temp"));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// maximum file size to be uploaded.
		upload.setSizeMax(maxFileSize);

		try {
			// Parse the request to get file items.
			List fileItems = upload.parseRequest(request);

			// Process the uploaded file items
			Iterator i = fileItems.iterator();

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet upload</title>");
			out.println("</head>");
			out.println("<body>");

			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next();
				if (!fi.isFormField()) {
					// Get the uploaded file parameters
					String fieldName = fi.getFieldName();
					String fileName = fi.getName();
					String contentType = fi.getContentType();
					boolean isInMemory = fi.isInMemory();
					long sizeInBytes = fi.getSize();

					// Write the file
					if (fileName.lastIndexOf("\\") >= 0) {
						file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
					} else {
						file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
						String index = "\\template\\image\\"+fileName;
						productService.saveImage(index,Long.parseLong(productid));
					}
					fi.write(file);
					out.println("Uploaded Filename: " + fileName + "<br>");
					out.println("<a href='/trang-chu'>Back to web</a>");
				}
			}
			out.println("</body>");
			out.println("</html>");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		String idProduct = request.getParameter("productid");
		request.setAttribute("idproduct", idProduct);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/product/productimage.jsp");
		rd.forward(request, response);
	}
}