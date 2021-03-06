package ar.edu.redLink.retailShop;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.redLink.retailShop.app.ClienteRepoREST;
import ar.edu.redLink.retailShop.app.Image;
import ar.edu.redLink.retailShop.app.ItemProductoRepoREST;
import ar.edu.redLink.retailShop.app.OrdenCompraRepoREST;
import ar.edu.redLink.retailShop.app.ProductoRepoREST;
import ar.edu.redLink.retailShop.app.PromocionesRepoREST;
import ar.edu.redLink.retailShop.app.ProveedorRepoREST;
import ar.edu.redLink.retailShop.app.UsuarioRepoREST;
import ar.edu.redLink.retailShop.app.VendedorRepoREST;
import ar.edu.redLink.retailShop.model.Cliente;
import ar.edu.redLink.retailShop.model.Cupones;
import ar.edu.redLink.retailShop.model.ItemProducto;
import ar.edu.redLink.retailShop.model.OrdenCompra;
import ar.edu.redLink.retailShop.model.Producto;
import ar.edu.redLink.retailShop.model.Promociones;
import ar.edu.redLink.retailShop.model.Proveedor;
import ar.edu.redLink.retailShop.model.RolUsuario;
import ar.edu.redLink.retailShop.model.TipoProducto;
import ar.edu.redLink.retailShop.model.Usuario;
import ar.edu.redLink.retailShop.model.Vendedor;

@Component
public class InitData implements CommandLineRunner {

	@Autowired
	UsuarioRepoREST repoUsuario;

	@Autowired
	ProveedorRepoREST repoProveedor;

	@Autowired
	ClienteRepoREST repoCliente;

	@Autowired
	VendedorRepoREST repoVendedor;

	@Autowired
	ProductoRepoREST repoProducto;

	
	@Autowired 
	ItemProductoRepoREST repoItemProducto;
	 

	@Autowired
	OrdenCompraRepoREST repoOrdenDeCompra;

	@Autowired
	RepositoryRestConfiguration config;
	
	@Autowired
	PromocionesRepoREST repoPromo;

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		config.getProjectionConfiguration().addProjection(AlumnoDTO2.class);
		config.exposeIdsFor(Producto.class, Promociones.class, Cupones.class, Image.class);

		// config.exposeIdsFor(OrdenDeCompra.class);

		
		  if (repoUsuario.count() != 0) { return; }
		 

		// Creacion de proveedores
		Proveedor proveedor1 = new Proveedor();
		proveedor1.setRazonSocial("DIARCO S.A");
		Proveedor proveedor2 = new Proveedor();
		proveedor2.setRazonSocial("COTO S.A");
		Proveedor proveedor3 = new Proveedor();
		proveedor3.setRazonSocial("DIA S.R.L");
		repoProveedor.save(proveedor1);
		repoProveedor.save(proveedor2);
		repoProveedor.save(proveedor3);

		// Creacion de usuario
		Usuario vendedor1 = new Usuario();
		vendedor1.setPassword("123456789");
		vendedor1.setUsername("vendedor1@vendedor.com.ar");
		vendedor1.setRol(RolUsuario.VENDEDOR);

		Usuario vendedor2 = new Usuario();

		vendedor2.setPassword("123456789");
		vendedor2.setUsername("vendedor2@vendedor.com.ar");
		vendedor2.setRol(RolUsuario.VENDEDOR);

		Usuario cliente1 = new Usuario();

		cliente1.setPassword("123456789");
		cliente1.setUsername("cliente1@cliente.com.ar");
		cliente1.setRol(RolUsuario.CLIENTE);

		Usuario cliente2 = new Usuario();

		cliente2.setPassword("123456789");
		cliente2.setUsername("cliente2@cliente.com.ar");
		cliente2.setRol(RolUsuario.CLIENTE);

		List<Usuario> usuariosIniciales = Arrays.asList(vendedor1, vendedor2, cliente2);

		usuariosIniciales.stream().forEach(usuario -> {
			repoUsuario.save(usuario);
		});

		// Creacion de compradores
		Cliente comprador1 = new Cliente();
		comprador1.setApellido("Rodriguez");
		comprador1.setNombre("Matias");
		comprador1.setNumeroDocumento("1");
		comprador1.setUsuario(cliente1);

		Cliente comprador2 = new Cliente();
		comprador2.setApellido("Gutierrez");
		comprador2.setNombre("Gerardo");
		comprador2.setNumeroDocumento("2");
		comprador2.setUsuario(cliente2);

		repoCliente.save(comprador1);
		repoCliente.save(comprador2);

		// Creacion de vendedores
		Vendedor vendedor11 = new Vendedor();
		vendedor11.setDni("1");
		vendedor11.setNombre("Alfredo Coto");
		vendedor11.setUsuario(vendedor1);
		Vendedor vendedor22 = new Vendedor();
		vendedor22.setDni("2");
		vendedor22.setNombre("Roberto Dia");
		vendedor22.setUsuario(vendedor2);
		repoVendedor.save(vendedor11);
		repoVendedor.save(vendedor22);

		// Creacion de productos
		Producto producto1 = new Producto();
		producto1.setTipoProducto(TipoProducto.INDUMENTARIA);
		producto1.setNombre("Campera Inflable Negra Super Abrigada Con Capucha");
		producto1.setPrecio(6586.00);
		producto1.setProveedorDeProducto(proveedor1);
		producto1.setFechaDePublicacion(LocalDate.now());
		producto1.setVendedor(vendedor22);
		producto1.setDescripcion("Descripci??n\r\n"
				+ "Campera Inflable Super Abrigada Talles Reales Grandes\r\n"
				+ "\r\n"
				+ "Color Disponible: NEGRO - AZUL OSCURO\r\n"
				+ "\r\n"
				+ "Talles Disponibles: S - M - L - XL - XXL - XXXL\r\n"
				+ "\r\n"
				+ "-SUPER ABRIGADAS\r\n"
				+ "\r\n");

		producto1.setActivo(true);
		
		
		Producto producto2 = new Producto();
		producto2.setTipoProducto(TipoProducto.TECNOLOGIA);
		producto2.setNombre("Televisor 42'' ULTRA HD ");
		producto2.setPrecio(51999.00);
		producto2.setProveedorDeProducto(proveedor1);
		producto2.setFechaDePublicacion(LocalDate.now());
		producto2.setVendedor(vendedor22);
		producto2.setDescripcion("TCL es una de las empresas l??deres en la industria global de televisores, dedicada a la investigaci??n y desarrollo de productos electr??nicos. Orientada a la satisfacci??n de sus clientes, se distingue por proveer una excelente experiencia a quienes adquieran y usen sus diferentes l??neas de electrodom??sticos.\r\n"
				+ "Con el Smart TV L42S6500 vas a acceder a las aplicaciones en las que se encuentran tus contenidos favoritos. Adem??s, pod??s navegar por Internet, interactuar en redes sociales y divertirte con videojuegos.");
		producto2.setActivo(true);
		
		Producto producto3 = new Producto();
		producto3.setTipoProducto(TipoProducto.TECNOLOGIA);
		producto3.setNombre("Placa de video AMD Sapphire Pulse Radeon RX 6500");
		producto3.setPrecio(50350.00);
		producto3.setProveedorDeProducto(proveedor2);
		producto3.setFechaDePublicacion(LocalDate.now());
		producto3.setVendedor(vendedor22);
		producto3.setActivo(true);
		producto3.setDescripcion("AMD es un fabricante estadounidense de placas de video, por su tecnolog??a se ha destacado en crear "
				+ "procesadores de alta gama que permiten un excelente funcionamiento del motor gr??fico de tu computadora.");

		Producto producto4 = new Producto();
		producto4.setActivo(true);
		producto4.setTipoProducto(TipoProducto.TECNOLOGIA);
		producto4.setNombre("Auriculares in-ear gamer inal??mbricos Haylou GT Series GT1 negro");
		producto4.setPrecio(2959.00);
		producto4.setProveedorDeProducto(proveedor1);
		producto4.setFechaDePublicacion(LocalDate.now());
		producto4.setVendedor(vendedor11);
		producto4.setDescripcion("Descripci??n\r\n"
				+ "Si quer??s disfrutar de unos auriculares con gran calidad de sonido, el modelo GT1 de Haylou es para vos. Con estos peque??os aparatos pod??s transportar m??sica a cualquier lugar y atender cualquier llamada con su micr??fono incorporado. Su gran autonom??a de funcionamiento, su control t??ctil y su compacta caja de carga lo vuelven el elegido por una amplia gama de p??blico.\r\n"
				+ "\r\n"
				+ "El formato perfecto para vos\r\n"
				+ "Al ser in-ear, mejoran la calidad del audio y son de tama??o peque??o para poder insertarse en tu oreja. Son ideales para acompa??arte a la hora de hacer ejercicio mientras te sumerg??s en el mejor sonido envolvente.");

		Producto producto5 = new Producto();
		producto5.setActivo(true);
		producto5.setTipoProducto(TipoProducto.INDUMENTARIA);
		producto5.setNombre("Pantal??n Jogging Jogger Babucha Con Cierres Frizado");
		producto5.setPrecio(2469.00);
		producto5.setProveedorDeProducto(proveedor1);
		producto5.setFechaDePublicacion(LocalDate.now());
		producto5.setVendedor(vendedor11);
		producto5.setDescripcion("Descripci??n\r\n"
				+ "* Pantal??n frizado\r\n"
				+ "* 2 bolsillos laterales con cierre.\r\n"
				+ "*Cordon para ajustar (El cordon es Color Negro en todos los pantalones)\r\n"
				+ "*Super abrigado y comodo .\r\n");
		
		
		Producto producto6 = new Producto();
		producto6.setActivo(true);
		producto6.setTipoProducto(TipoProducto.VEHICULO);
		producto6.setNombre("Volkswagen amarok 3.0 258cv v6 comfortline");
		producto6.setPrecio(6000000.00);
		producto6.setProveedorDeProducto(proveedor1);
		producto6.setFechaDePublicacion(LocalDate.now());
		producto6.setVendedor(vendedor11);
		producto6.setDescripcion("RETIRAS EN 15 D??AS REALES.\r\n"
				+ "\r\n"
				+ "DEJANOS TU CONTACTO ASI PODEMOS ASESORARTE\r\n"
				+ "\r\n"
				+ "ESTAMOS AUTORIZADOS PARA REALIZAR GESTIONES EN CUALQUIER PARTE DEL PAIS POR VOLKSWAGEN ARGENTINA\r\n"
				+ "\r\n"
				+ "Con garant??a de f??brica\r\n"
				+ "Primeros 3 primeros service??s bonificados\r\n"
				+ "Garant??a de 6 a??os o 150.000km\r\n"
				+ "Mano de obra bonificada en 4?? service");

		
		Producto producto7 = new Producto();
		producto7.setActivo(true);
		producto7.setTipoProducto(TipoProducto.VEHICULO);
		producto7.setNombre("Peugeot 208 1.6 Allure Nav Tiptronic - Usado");
		producto7.setPrecio(2580000.00);
		producto7.setProveedorDeProducto(proveedor1);
		producto7.setFechaDePublicacion(LocalDate.now());
		producto7.setVendedor(vendedor11);
		producto7.setDescripcion("Listo para transferir, muy bueno digno de ver, detalles a la vista, precio publicado de contado" + "Con garant??a de f??brica\r\n"
				+ "Primeros 3 primeros service??s bonificados\r\n"
				+ "Garant??a de 6 a??os o 150.000km\r\n"
				+ "Mano de obra bonificada en 4?? service");
		
		
		
		
		Producto producto8 = new Producto();
		producto8.setActivo(true);
		producto8.setTipoProducto(TipoProducto.INDUMENTARIA);
		producto8.setNombre("Jaguar 4325 Hombre Adultos\r\n");
		producto8.setPrecio(7477.00);
		producto8.setProveedorDeProducto(proveedor1);
		producto8.setFechaDePublicacion(LocalDate.now());
		producto8.setVendedor(vendedor11);
		producto8.setDescripcion("Jaguar cuenta con una completa l??nea de calzados especialmente pensados para sus clientes. Sus productos son novedosos y c??modos. Se adaptan a tu rutina.\r\n"
				+ "\r\n"
				+ "Zapatillas de tela\r\n"
				+ "Son ideales para los d??as calurosos ya que permiten que el pie respire mejor. Vers??tiles, adaptables a cualquier situaci??n y outfit, y adem??s son f??ciles de lavar.");
		
		
		
		
		Producto producto9 = new Producto();
		producto9.setActivo(true);
		producto9.setTipoProducto(TipoProducto.INDUMENTARIA);
		producto9.setNombre("Topper Dakota Hombre Adultos");
		producto9.setPrecio(11399.00);
		producto9.setProveedorDeProducto(proveedor1);
		producto9.setFechaDePublicacion(LocalDate.now());
		producto9.setVendedor(vendedor11);
		producto9.setDescripcion("Topper se destaca en el mercado por ofrecer productos de calidad, confort y dise??o que unen moda y deporte. Acerca tendencias y busca que las personas puedan verse y sentirse bien dentro y fuera del campo de juego.\r\n"
				+ "\r\n"
				+ "Suela de goma\r\n"
				+ "Las zapatillas fabricadas con suela de goma tienen mayor resistencia al desgaste, son naturalmente impermeables y flexibles, y adem??s extienden la estabilidad de la contracci??n.");
		
		
		
		Producto producto10 = new Producto();
		producto10.setActivo(true);
		producto10.setTipoProducto(TipoProducto.INDUMENTARIA);
		producto10.setNombre("Topper Boro II Hombre Adultos");
		producto10.setPrecio(9398.00);
		producto10.setProveedorDeProducto(proveedor1);
		producto10.setFechaDePublicacion(LocalDate.now());
		producto10.setVendedor(vendedor11);
		producto10.setDescripcion("Topper se destaca en el mercado por ofrecer productos de calidad, confort y dise??o que unen moda y deporte. Acerca tendencias y busca que las personas puedan verse y sentirse bien dentro y fuera del campo de juego.\r\n"
				+ "\r\n"
				+ "Zapatillas de cuero sint??tico\r\n"
				+ "Este tipo de material hace que sean m??s duraderas. El cuero sint??tico resiste el agua, funcionado como aislante para que el pie no se moje. Son f??ciles de lavar y mantener, ideales para cualquier situaci??n, asegurando comodidad y estilo.");
		
			

		repoProducto.save(producto1);
		repoProducto.save(producto2);
		repoProducto.save(producto3);
		repoProducto.save(producto4);
		repoProducto.save(producto5);
		repoProducto.save(producto6);
		repoProducto.save(producto7);
		repoProducto.save(producto8);
		repoProducto.save(producto9);
		repoProducto.save(producto10);

		// Creacion de items producto
		ItemProducto item1 = new ItemProducto();
		item1.setCantidad(2);
		item1.setPrecioUnitario(10.00);
		item1.setProductoSeleccionado(producto1);

		ItemProducto item2 = new ItemProducto();
		item2.setCantidad(1);
		item2.setPrecioUnitario(10.00);
		item2.setProductoSeleccionado(producto2);

		ItemProducto item3 = new ItemProducto();
		item3.setCantidad(3);
		item3.setPrecioUnitario(10.00);
		item3.setProductoSeleccionado(producto3);

		ItemProducto item4 = new ItemProducto();
		item4.setCantidad(4);
		item4.setPrecioUnitario(10.00);
		item4.setProductoSeleccionado(producto3);

		ItemProducto item5 = new ItemProducto();
		item5.setCantidad(5);
		item5.setPrecioUnitario(10.00);
		item5.setProductoSeleccionado(producto4);

		ItemProducto item6 = new ItemProducto();
		item6.setCantidad(6);
		item6.setPrecioUnitario(10.00);
		item6.setProductoSeleccionado(producto5);

		List<ItemProducto> itemsIniciales = Arrays.asList(item1, item2, item3, item4, item5, item6);

		itemsIniciales.stream().forEach(item -> {
			repoItemProducto.save(item);
		});

		// Creacion de ordenes de compra
		OrdenCompra orden1 = new OrdenCompra();
		orden1.setItemComprado(item1);
		orden1.setFechaCompra(LocalDate.now());
		orden1.setVendedor(vendedor11);
		orden1.setClienteComprador(comprador1);		
		
		OrdenCompra orden2 = new OrdenCompra();
		orden2.setItemComprado(item2);
		orden2.setFechaCompra(LocalDate.now());
		orden2.setVendedor(vendedor11);
		orden2.setClienteComprador(comprador1);		
		
		
		OrdenCompra orden3 = new OrdenCompra();
		orden3.setItemComprado(item3);
		orden3.setFechaCompra(LocalDate.now());
		orden3.setVendedor(vendedor22);
		orden3.setClienteComprador(comprador2);		
		
		repoOrdenDeCompra.save(orden1);
		repoOrdenDeCompra.save(orden2);
		repoOrdenDeCompra.save(orden3);
		
		
		Cupones cuponDe1000 = new Cupones();
		cuponDe1000.setCodigoCupon("cuponde1000");
		cuponDe1000.setEstaUsado(false);
		cuponDe1000.setValorDeDescuento(1000);
		Cupones cuponDe2000 = new Cupones();
		cuponDe2000.setCodigoCupon("cuponde2000");
		cuponDe2000.setEstaUsado(false);
		cuponDe2000.setValorDeDescuento(2000);
		Cupones cuponDe3000 = new Cupones();
		cuponDe3000.setCodigoCupon("cuponde3000");
		cuponDe3000.setEstaUsado(false);
		cuponDe3000.setValorDeDescuento(3000);
		

		repoPromo.save(cuponDe1000);
		repoPromo.save(cuponDe2000);
		repoPromo.save(cuponDe3000);
		
		
		
		
		
	}

}