package ch_07;

public class GraphUtil {
    public static Graph init() {
        Graph graph = new Graph();

        Vertex kiyv = Vertex.of("Київ");
        Vertex jitomir = Vertex.of("Житомир");
        Vertex luck = Vertex.of("Луцьк");
        Vertex rivne = Vertex.of("Рівне");
        Vertex lviv = Vertex.of("Львів");
        Vertex ternopil = Vertex.of("Тернопіль");
        Vertex hmelnickiy = Vertex.of("Хмельницький");
        Vertex vinniza = Vertex.of("Вінниця");
        Vertex uman = Vertex.of("Умань");
        Vertex chernigiv = Vertex.of("Чернігів");
        Vertex cherkassi = Vertex.of("Черкаси");
        Vertex kropivnickiy = Vertex.of("Кропівницький");
        Vertex kriviy = Vertex.of("Кривий ріг");
        Vertex sumi = Vertex.of("Суми");
        Vertex poltava = Vertex.of("Полтава");
        Vertex kremenchuk = Vertex.of("Кременчук");
        Vertex dnipro = Vertex.of("Дніпро");
        Vertex zaporijha = Vertex.of("Запоріжжя");
        Vertex harkiv = Vertex.of("Харків");
        Vertex odesa = Vertex.of("Одеса");
        Vertex mikolaiv = Vertex.of("Миколаїв");
        Vertex herson = Vertex.of("Херсон");

        kiyv.addNeighbor(jitomir, 140);
        kiyv.addNeighbor(vinniza, 272);
        kiyv.addNeighbor(uman, 212);
        kiyv.addNeighbor(kropivnickiy, 303);
        kiyv.addNeighbor(cherkassi, 193);
        kiyv.addNeighbor(poltava, 352);
        kiyv.addNeighbor(harkiv, 489);
        kiyv.addNeighbor(sumi, 334);
        kiyv.addNeighbor(chernigiv, 157);
        graph.addVertex(kiyv);

        jitomir.addNeighbor(kiyv, 140);
        jitomir.addNeighbor(vinniza, 132);
        jitomir.addNeighbor(rivne, 190);
        jitomir.addNeighbor(hmelnickiy, 192);
        graph.addVertex(jitomir);

        rivne.addNeighbor(jitomir, 190);
        rivne.addNeighbor(luck, 73);
        rivne.addNeighbor(ternopil, 160);
        rivne.addNeighbor(hmelnickiy, 195);
        graph.addVertex(rivne);

        luck.addNeighbor(rivne, 73);
        luck.addNeighbor(lviv, 152);
        luck.addNeighbor(ternopil, 169);
        graph.addVertex(luck);

        lviv.addNeighbor(luck, 152);
        lviv.addNeighbor(ternopil, 128);
        graph.addVertex(lviv);

        ternopil.addNeighbor(hmelnickiy, 112);
        ternopil.addNeighbor(rivne, 160);
        ternopil.addNeighbor(luck, 169);
        ternopil.addNeighbor(lviv, 128);
        graph.addVertex(ternopil);

        hmelnickiy.addNeighbor(ternopil, 112);
        hmelnickiy.addNeighbor(rivne, 195);
        hmelnickiy.addNeighbor(jitomir, 192);
        hmelnickiy.addNeighbor(vinniza, 121);
        graph.addVertex(hmelnickiy);

        vinniza.addNeighbor(hmelnickiy, 121);
        vinniza.addNeighbor(jitomir, 132);
        vinniza.addNeighbor(kiyv, 272);
        vinniza.addNeighbor(uman, 162);
        graph.addVertex(vinniza);

        uman.addNeighbor(vinniza, 162);
        uman.addNeighbor(kiyv, 212);
        uman.addNeighbor(kropivnickiy, 166);
        uman.addNeighbor(odesa, 271);
        graph.addVertex(uman);

        kropivnickiy.addNeighbor(uman, 166);
        kropivnickiy.addNeighbor(kiyv, 303);
        kropivnickiy.addNeighbor(cherkassi, 129);
        kropivnickiy.addNeighbor(kremenchuk, 136);
        kropivnickiy.addNeighbor(dnipro, 246);
        kropivnickiy.addNeighbor(kriviy, 120);
        kropivnickiy.addNeighbor(mikolaiv, 183);
        graph.addVertex(kropivnickiy);

        cherkassi.addNeighbor(kiyv, 193);
        cherkassi.addNeighbor(poltava, 257);
        cherkassi.addNeighbor(kremenchuk, 131);
        cherkassi.addNeighbor(kropivnickiy, 129);
        graph.addVertex(cherkassi);

        chernigiv.addNeighbor(kiyv, 157);
        chernigiv.addNeighbor(sumi, 340);
        graph.addVertex(chernigiv);

        sumi.addNeighbor(kiyv, 334);
        sumi.addNeighbor(cherkassi, 340);
        sumi.addNeighbor(harkiv, 186);
        graph.addVertex(sumi);

        harkiv.addNeighbor(poltava, 143);
        harkiv.addNeighbor(kiyv, 489);
        harkiv.addNeighbor(sumi, 186);
        graph.addVertex(harkiv);

        poltava.addNeighbor(kremenchuk, 113);
        poltava.addNeighbor(cherkassi, 257);
        poltava.addNeighbor(kiyv, 352);
        poltava.addNeighbor(harkiv, 143);
        poltava.addNeighbor(dnipro, 201);
        graph.addVertex(poltava);

        kremenchuk.addNeighbor(kropivnickiy, 136);
        kremenchuk.addNeighbor(cherkassi, 131);
        kremenchuk.addNeighbor(poltava, 113);
        kremenchuk.addNeighbor(dnipro, 162);
        graph.addVertex(kremenchuk);

        dnipro.addNeighbor(kropivnickiy, 246);
        dnipro.addNeighbor(kremenchuk, 162);
        dnipro.addNeighbor(poltava, 201);
        dnipro.addNeighbor(harkiv, 218);
        dnipro.addNeighbor(zaporijha, 86);
        dnipro.addNeighbor(kriviy, 146);
        graph.addVertex(dnipro);

        zaporijha.addNeighbor(dnipro, 86);
        zaporijha.addNeighbor(herson, 349);
        graph.addVertex(zaporijha);

        kriviy.addNeighbor(mikolaiv, 182);
        kriviy.addNeighbor(kropivnickiy, 120);
        kriviy.addNeighbor(dnipro, 146);
        graph.addVertex(kriviy);

        mikolaiv.addNeighbor(odesa, 153);
        mikolaiv.addNeighbor(kropivnickiy, 183);
        mikolaiv.addNeighbor(kriviy, 182);
        mikolaiv.addNeighbor(herson, 68);
        graph.addVertex(mikolaiv);

        herson.addNeighbor(mikolaiv,68);
        herson.addNeighbor(zaporijha, 349);
        graph.addVertex(herson);

        odesa.addNeighbor(uman, 271);
        odesa.addNeighbor(mikolaiv, 153);
        graph.addVertex(odesa);

        return graph;
    }
}
