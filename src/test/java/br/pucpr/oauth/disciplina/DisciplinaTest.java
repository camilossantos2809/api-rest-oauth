package br.pucpr.oauth.disciplina;

import br.pucpr.oauth.controller.DisciplinaController;
import br.pucpr.oauth.repository.DisciplinaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(DisciplinaController.class)
@AutoConfigureRestDocs
@AutoConfigureMockMvc
public class DisciplinaTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private DisciplinaRepository repository;

    @Test
    void listDisciplinas() throws Exception {
        this.mvc.perform(get("/disciplinas").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("list-disciplinas"));
    }
}
