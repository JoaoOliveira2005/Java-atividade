import java.util.ArrayList;
import java.util.List;

public class Ensalamento {


    public static void executarEnsalamento() {


        Curso ti = new Curso("TI");
        Curso adm = new Curso("ADM");


        Disciplina poo = new Disciplina("POO", ti);
        Disciplina estruturaDados = new Disciplina("Estrutura de Dados", ti);
        Disciplina bi = new Disciplina("BI", adm);


        ti.addDisciplina(poo);
        ti.addDisciplina(estruturaDados);
        adm.addDisciplina(bi);


        Professor mia = new Professor("Mia", poo);
        Professor saulo = new Professor("Saulo", estruturaDados);
        Professor paula = new Professor("Paula", bi);



        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("Alfredo", ti));
        alunos.add(new Aluno("Amélia", ti));
        alunos.add(new Aluno("Ana", adm));
        alunos.add(new Aluno("Bruno", ti));
        alunos.add(new Aluno("Bentinho", adm));
        alunos.add(new Aluno("Capitú", ti));
        alunos.add(new Aluno("Debra", ti));
        alunos.add(new Aluno("Ian", adm));
        alunos.add(new Aluno("Iracema", ti));
        alunos.add(new Aluno("Joelmir", adm));
        alunos.add(new Aluno("Julieta", ti));
        alunos.add(new Aluno("Luana", adm));
        alunos.add(new Aluno("Luciana", ti));
        alunos.add(new Aluno("Majô", adm));
        alunos.add(new Aluno("Maria", adm));
        alunos.add(new Aluno("Norberto", ti));
        alunos.add(new Aluno("Paulo", adm));
        alunos.add(new Aluno("Romeu", adm));
        alunos.add(new Aluno("Wendel", ti));
        alunos.add(new Aluno("Zoey", ti));



        Turma turmaPOO = new Turma(mia, poo);
        Turma turmaED = new Turma(saulo, estruturaDados);
        Turma turmaBI = new Turma(paula, bi);




        for (Aluno aluno : alunos) {
            if (aluno.getCurso().getNome().equals("TI")) {
                if (aluno.getNome().charAt(0) < 'N') {
                    turmaPOO.addAluno(aluno);
                } else {
                    turmaED.addAluno(aluno);
                }
            } else if (aluno.getCurso().getNome().equals("ADM")) {
                turmaBI.addAluno(aluno);
            }
        }



        turmaPOO.printTurma();
        turmaED.printTurma();
        turmaBI.printTurma();
    }
}
