//package fut.manager.api.service;
//
//import fut.manager.api.models.entities.Clube;
//import fut.manager.api.models.entities.Jogador;
//import fut.manager.api.models.enums.Posicao;
//import fut.manager.api.models.enums.StatusJogador;
//import fut.manager.api.models.records.DadosCadastroJogador;
//import fut.manager.api.models.records.DadosEndereco;
//import fut.manager.api.repository.ClubeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//
//@Service
//public class DBService {
//
//    @Autowired
//    private ClubeRepository clubeRepository;
//
//    public void instanciaDB() {
//
//        Clube clube1 = new Clube(null, "Ceará", "12345678900000", LocalDate.parse("02-06-1914"), "Vovô",
//                new DadosEndereco("Av João Pessoa", "Porangabussu", "", "Fortaleza", "CE", "", ""), null);
//
//        Jogador jogador1 = new Jogador(null, "Pansera", "2222222222", "pansera@mail.com", LocalDate.parse("02-06-1980"), 44, Posicao.ATACANTE, StatusJogador.ATLETA,
//                new DadosEndereco("Av João Pessoa", "Porangabussu", "", "Fortaleza", "CE", "", ""), clube1);
//
//    }
//}
