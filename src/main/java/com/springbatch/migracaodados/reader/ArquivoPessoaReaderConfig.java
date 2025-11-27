package com.springbatch.migracaodados.reader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.validation.BindException;

import com.springbatch.migracaodados.dominio.Pessoa;

@Configuration
public class ArquivoPessoaReaderConfig {
	@Bean
	public FlatFileItemReader<Pessoa> arquivoPessoaReader() {
		return new FlatFileItemReaderBuilder<Pessoa>()
				.name("arquivoPessoaReader")
				.resource(new FileSystemResource("files/pessoas.csv"))
				.delimited()
				.names("nome", "email", "dataNascimento", "idade", "id")
				.addComment("--")
				.fieldSetMapper(fieldSetMapper())
				.build();
	}

	private FieldSetMapper<Pessoa> fieldSetMapper() {
		return new FieldSetMapper<Pessoa>() {

			@Override
			public Pessoa mapFieldSet(FieldSet fieldSet) throws BindException {
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(fieldSet.readString("nome"));
				pessoa.setEmail(fieldSet.readString("email"));

				String dataNascimentoStr = fieldSet.readString("dataNascimento");
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					pessoa.setDataNascimento(new Date(dateFormat.parse(dataNascimentoStr).getTime()));
				} catch (ParseException e) {
					throw new IllegalArgumentException("Unparseable date: \"" + dataNascimentoStr + "\", format: [" + dateFormat.toPattern() + "], name: [dataNascimento]", e);
				}

				pessoa.setIdade(fieldSet.readInt("idade"));
				pessoa.setId(fieldSet.readInt("id"));
				return pessoa;
			}
		};
	}
}