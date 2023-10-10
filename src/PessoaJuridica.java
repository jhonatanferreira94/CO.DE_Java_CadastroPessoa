import java.time.LocalDate;

public class PessoaJuridica extends Pessoa{

    public String cnpj;
    public String razaoSocial;


    public float CalcularImposto(float rendimento) {
        /* Até 3000 - 3%
         * de 3000 a 6000 - 5%
         * de 6000 a 10000 - 7%
         * acima de 10000 - 9%
         * */

        if (rendimento<=3000) {
            return rendimento* .03f;
        } else if (rendimento<=6000) {
            return rendimento* .5f;
        } else if (rendimento<=10000) {
            return rendimento* .75f;
        }else {
            return rendimento* .9f;
        }
    }

}
