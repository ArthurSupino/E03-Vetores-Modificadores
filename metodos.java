import java.util.Random;
import java.util.Scanner;

public class metodos
{   
    static int conta_usada;
    static  int option_c;
    static  Random random;
    static int cadastro_feito;
    static Scanner sc = new Scanner(System.in);
    static String senha_ins;
    static int temp;
    static int conta_reg;
    static int conta_regS;
    

    static void depositar()
    {
        int depositado;
        System.out.println("digite a quantia a ser depositada: ");
        depositado = sc.nextInt();

        Cliente.saldo[temp] += depositado;
        Cliente.registro_de_deposito[temp][conta_reg] = "deposito executado";
    }
    static void sacar()
    {
        int saqueado;
        System.out.println("digite a quantia a ser sacada: ");
        saqueado = sc.nextInt();

        if(saqueado > Cliente.Saldo[temp])
        {
            System.out.println("Saldo insuficiente , tente outro valor");
        }
        else
        {
            Cliente.saldo[temp] = Cliente.saldo[temp] - saqueado;
            Cliente.registro_de_saque[temp][conta_regS] = "saque executado";

        }
    }

    
    static void criar_conta()
    {
        
        System.out.println("digite seu nome");
        Cliente.nome_dono[Cliente.numero_da_conta] = sc.next();

        random   =  new Random();

        Cliente.numero_conta[Cliente.numero_da_conta] = random.nextInt(1000);

        System.out.println("digite seu genero 'm' ou 'f'");
        Cliente.sexo[Cliente.numero_da_conta] = sc.next().charAt(0);

        System.out.println("digite seu cep : ");
        Cliente.endereco[Cliente.numero_da_conta] = sc.next();

        System.out.println("digite seu cpf : ");
        Cliente.cpf[Cliente.numero_da_conta] = sc.next();

        System.out.println("digite sua idade");
        Cliente.idade[Cliente.numero_da_conta] = sc.nextInt();

        System.out.println("crie sua senha : ");
        Cliente.senha[Cliente.numero_da_conta] = sc.next();

        Cliente.numero_da_conta++;
    }

    public static void main(String[] args)
    {
        
        System.out.println("Bem vindo ao banco do Supino");
        System.out.println("Vamos comecar seu cadastro?");
        System.out.println("[1]-Sim [2]-Não");
        option_c = sc.nextInt();
        int option_a;

        if(option_c == 1)
        {
            criar_conta();
            cadastro_feito = 1;
           
        }
        else if(option_c != 2 && option_c != 1)
        {
            System.out.println("opcao invalida");
        }
        else
        {
            System.out.println("encerrando o app");
        }
        if(cadastro_feito == 1)
        {
            System.out.println("digite sua senha para entrar no app : ");
            senha_ins = sc.next();

            for(int j = 0 ; j < Cliente.numero_da_conta ; j++)
            {
                if(senha_ins == Cliente.senha[j])
                {
                    temp = j; 
                    do
                    {
                        System.out.println("digite qual acao voce deseja executar no seu banco: [0] - sair [1] - depositar [2] - sacar");
                        option_a = sc.nextInt();

                        switch (option_a) {
                            case 0:
                                conta_reg = 0;
                                conta_regS = 0;
                                System.out.println("saindo");
                                break;
                            case 1:
                                depositar();
                                conta_reg++;
                                break;

                            case 2:
                                sacar();
                                conta_regS++;
                                break;
                        
                            default:
                                break;
                        }

                    }while(option_a != 0);

                }
            }
            
        }

    }
}