CREATE OR REPLACE PROCEDURE VOTO.PR_VALIDA_VOTANTE(
						p_cedula        	IN       VARCHAR2,
						p_respuesta         OUT       VARCHAR2
)
AS
    CURSOR C_VALIDA_EXISTE IS
		SELECT COUNT(*)	
			FROM VOTANTE 
		WHERE CEDULA_VOTANTE = p_cedula
	;
	
	CURSOR C_AUDI IS
	SELECT 
		FECHA_INICIO, FECHA_FIN,VOTO
	FROM VOTO.AUDITORIA_VOTO
		WHERE CEDUL_VOTANTE = p_cedula
	;
	
	
	v_cont 			NUMBER:=0;
	v_fechaInicio 	DATE;
	v_fechaFin 		DATE;
	v_yaVoto 		NUMBER:=0;
	
BEGIN


	OPEN C_VALIDA_EXISTE;
	FETCH C_VALIDA_EXISTE INTO v_cont;
	CLOSE C_VALIDA_EXISTE;
	
	IF v_cont  = 0 THEN 
		
		p_respuesta:= 'EL VOTANTE NO EXISTE';
		
		RETURN;
		
	END IF;
	
	v_cont:=0;
	
	OPEN C_AUDI;
	FETCH C_AUDI INTO v_fechaInicio,v_fechaFin,v_yaVoto;
	CLOSE C_AUDI;
	
	IF v_fechaInicio IS NULL THEN 
		
		p_respuesta:= 'OK';
		
		INSERT INTO VOTO.AUDITORIA_VOTO (
		CEDULA_VOTANTE, FECHA_INICIO, FECHA_FIN, VOTO) 
		VALUES ( 
		p_cedula,
		SYSDATE,
		NULL,
		0 );
		
		RETURN;
		
	ELSIF v_fechaFin IS NULL THEN

		p_respuesta:= 'EL VOTANTE YA HA INGRESADO A VOTAR';
		
		RETURN;
		
	ELSE
		
		p_respuesta:= 'EL VOTANTE YA HA VOTADO';
		
		RETURN;
	
	END IF;
	
	
	
EXCEPTION
   WHEN OTHERS
   THEN
      ROLLBACK;
      p_respuesta := SQLERRM;
      raise_application_error (-20999, '' || SQLERRM);
END;
/
