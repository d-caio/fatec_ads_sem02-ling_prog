import menus.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        var menuPrincipal = new MenuPrincipal();

        int opcaoSelecionada = menuPrincipal.selecionarOpcao();

        System.out.println(opcaoSelecionada);
    }
}
