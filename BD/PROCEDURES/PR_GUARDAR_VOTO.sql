CREATE OR REPLACE PROCEDURE VOTO.PR_GUARDAR_VOTO(
						p_cedula        	IN       VARCHAR2,
						p_puesto        	IN       VARCHAR2,
						p_canditato        	IN       VARCHAR2,
						p_respuesta         OUT       VARCHAR2
)
AS
    
	
	v_cont 			NUMBER:=0;
	v_rta			VARCHAR2(100):='';
	
BEGIN

	PR_VALIDA_VOTANTE(p_cedula,v_rta);
	
	
	IF v_rta != 'EL VOTANTE YA HA INGRESADO A VOTAR' THEN
		
		p_respuesta:= v_rta;
		
		RETURN;
		
	END IF;
	
	INSERT INTO VOTO.DETALLE_VOTO (
			ID_VOTO, ID_CANDIDATO, ID_PUESTO) 
	VALUES ((SELECT NVL(MAX(ID_VOTO)+1,1) FROM DETALLE_VOTO ),
	p_canditato,
	p_puesto );
		
	UPDATE VOTO.AUDITORIA_VOTO
		SET VOTO = 1,
		FECHA_FIN = SYSDATE
	WHERE CEDULA_VOTANTE = p_cedula;
	
	p_respuesta:='OK';
	
EXCEPTION
   WHEN OTHERS
   THEN
      ROLLBACK;
      p_respuesta := SQLERRM;
      raise_application_error (-20999, '' || SQLERRM);
END;
/
