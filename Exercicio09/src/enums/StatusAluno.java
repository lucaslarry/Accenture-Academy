package enums;

public enum StatusAluno {
    APROVADO,
    RECUPERACAO,
    REPROVADO;

    public static StatusAluno classificarPorMedia(double media) {
        return (media >= 70) ? APROVADO :
                (media >= 50) ? RECUPERACAO : REPROVADO;
    }
}