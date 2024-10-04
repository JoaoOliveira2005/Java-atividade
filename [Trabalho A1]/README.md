Sistema de Alocação de Estudantes em Turmas:

Este projeto é uma simulação da alocação de estudantes em turmas de uma instituição de ensino, utilizando conceitos de orientação a objetos em Java. O sistema agrupa alunos em turmas com base nos cursos e disciplinas oferecidas pela instituição.

O que o projeto faz?

Este projeto resolve um problema comum nas instituições de ensino: como alocar os alunos corretamente nas turmas, de acordo com seus cursos e disciplinas. De forma resumida, o sistema faz o seguinte:

Agrupa alunos conforme o curso e as disciplinas em que estão matriculados.
Atribui professores às turmas, de acordo com a disciplina que eles lecionam.
Mostra a lista final de turmas, com os professores, disciplinas e os alunos matriculados em cada uma delas.
Estrutura do Projeto
O projeto foi desenvolvido com base nos princípios da orientação a objetos, ou seja, cada conceito do problema é representado por uma classe específica. Abaixo está um resumo das principais classes e suas funções:

Classes Principais:

Pessoa: A classe base que representa as características comuns entre alunos e professores. A única característica destacada até o momento é o nome.

Aluno: Herda da classe Pessoa. Um aluno está matriculado em um curso específico, e será alocado em turmas conforme as disciplinas oferecidas por esse curso.

Professor: Também herda da classe Pessoa. O professor está associado a uma disciplina, ou seja, ele é o responsável por ministrar aulas de uma disciplina específica.

Curso: Representa um curso, como "TI" ou "ADM". Um curso tem várias disciplinas associadas, que os alunos desse curso devem cursar.

Disciplina: Cada disciplina pertence a um curso e é lecionada por um professor.

Turma: É a combinação de um professor, uma disciplina e os alunos matriculados. Ela representa o "grupo" de alunos que frequentam as aulas daquela disciplina com um professor específico.

Ensalamento: É a classe responsável por organizar (ou "ensalar") os alunos nas turmas corretas e exibir o resultado.

Como o projeto funciona?

Criação dos cursos: São criados os cursos "TI" e "ADM".
Criação das disciplinas: Disciplinas como "POO" e "Estrutura de Dados" são associadas ao curso de TI, e "BI" ao curso de ADM.
Professores: Cada disciplina tem um professor associado.
Alunos: Os alunos são criados e matriculados em seus respectivos cursos.
Alocação nas turmas: Alunos de TI são distribuídos entre as disciplinas de TI, e alunos de ADM são alocados em suas disciplinas. A alocação é feita com base na primeira letra do nome do aluno (como uma forma simples de distribuição).
Exibição das turmas: Por fim, o sistema exibe as turmas com seus professores e alunos matriculados.
