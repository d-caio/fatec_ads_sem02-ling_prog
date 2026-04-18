package menus;

public class MenuPrincipal extends MenuDeOpcoes{
    public MenuPrincipal() {
        super(
            "Menu Principal",
            new Opcao(1, "Carregar notas"),
            new Opcao(2, "Retirar notas"),
            new Opcao(3, "Estatísticas"),
            new Opcao(9, "Fim")
        );
    }
}
