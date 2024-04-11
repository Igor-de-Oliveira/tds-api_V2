CREATE TABLE Local (
                       id_Local INT(11) PRIMARY KEY AUTO_INCREMENT,
                       Local_Name VARCHAR(45) NOT NULL,
                       Local_Cap INT(11) NOT NULL,
                       Local_End VARCHAR(45) NOT NULL,
                       Local_disp VARCHAR(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Evento (
                        id_Evento INT(11) PRIMARY KEY AUTO_INCREMENT,
                        Evento_D_H DATETIME NOT NULL,
                        Evento_Dur INT(11) NULL DEFAULT NULL,
                        Evento_Num_Conv INT(11) NOT NULL,
                        id_Local INT(11) NOT NULL,
                        FOREIGN KEY (id_Local) REFERENCES Local (id_Local)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Funcionario (
                             id_Funcionario INT(11) PRIMARY KEY AUTO_INCREMENT,
                             Funcionario_CPF VARCHAR(45) NOT NULL,
                             Funcionario_End VARCHAR(45) NOT NULL,
                             Funcionario_Cel INT(11) NOT NULL,
                             id_Evento INT(11) NOT NULL,
                             FOREIGN KEY (id_Evento) REFERENCES Evento (id_Evento)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Reserva (
                         id_Reserva INT(11) PRIMARY KEY AUTO_INCREMENT,
                         Reserva_status VARCHAR(45) NOT NULL,
                         Reserva_Data VARCHAR(45) NOT NULL,
                         id_Local INT(11) NOT NULL,
                         id_Funcionario INT(11) NOT NULL,
                         FOREIGN KEY (id_Local) REFERENCES Local (id_Local),
                         FOREIGN KEY (id_Funcionario) REFERENCES Funcionario (id_Funcionario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Usuario (
                         id_Usuario INT(11) PRIMARY KEY AUTO_INCREMENT,
                         Usuario_name VARCHAR(45) NOT NULL,
                         Usuario_idade INT(11) NOT NULL,
                         Usuario_pass VARCHAR(45) NOT NULL,
                         Usuario_end VARCHAR(45) NOT NULL,
                         Usuario_email VARCHAR(45) NOT NULL,
                         Usuario_nasc DATE NOT NULL,
                         id_Reserva INT(11) NOT NULL,
                         FOREIGN KEY (id_Reserva) REFERENCES Reserva (id_Reserva)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Pagamento (
                           id_Pagamento INT(11) PRIMARY KEY AUTO_INCREMENT,
                           Pagamento_status VARCHAR(45) NOT NULL,
                           id_Usuario INT(11) NOT NULL,
                           id_Local INT(11) NOT NULL,
                           FOREIGN KEY (id_Usuario) REFERENCES Usuario (id_Usuario),
                           FOREIGN KEY (id_Local) REFERENCES Local (id_Local)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE avaliacao (
                           id_avaliacao INT(11) PRIMARY KEY AUTO_INCREMENT,
                           avaliacao_Desc VARCHAR(45) NOT NULL,
                           id_Usuario INT(11) NOT NULL,
                           FOREIGN KEY (id_Usuario) REFERENCES Usuario (id_Usuario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
