package com.ubintis.boot;

import com.ubintis.boot.input.DatabaseModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
@Slf4j
public class SocialLoginInstallApplication implements CommandLineRunner {

	public static void main( String[] args ) {

		SpringApplication.run( com.ubintis.boot.SocialLoginInstallApplication.class, args );
	}

	public void run( String[] args ) throws Exception {

		log.info( "\n\n" );
		log.info( "################################################################################\n" );
		log.info( "################################################################################\n" );
		log.info( "### \n" );
		log.info( "### 소셜 로그인 세팅 모듈 \n" );
		log.info( "### \n" );
		log.info( "################################################################################\n" );
		log.info( "### \n" );
		Scanner scanner = new Scanner( System.in, "EUC-KR" );
		boolean flag = true;

		while( flag ) {
			log.info( "################################################################################\n" );
			log.info( "\n" );
			log.info( "type nubmer prompt 'Enter the type(1:Social Login Install, 9:exit)' : " );
			String type = scanner.nextLine();

			if( "1".equals( type ) ) {
				install( scanner );
				flag = false;
				continue;
			}
			if( "9".equals( type ) ) {
				flag = false;
				continue;
			}
		}

	}

	private void install( Scanner scanner ) {

		DatabaseModule databaseModule = new DatabaseModule();

		log.info( "################################################################################\n" );
		log.info( " install \n" );
		log.info( "################################################################################\n" );

		// 1. DB 접속 정보 입력 받기
		System.out.print( " DB URL을 입력하세요: " );
		String dbUrl = scanner.nextLine();

		System.out.print( " DB 사용자명을 입력하세요: " );
		String dbUser = scanner.nextLine();

		System.out.print( " DB 비밀번호를 입력하세요: " );
		String dbPassword = scanner.nextLine();

		// 2. 테이블 생성 (없으면 생성)
		databaseModule.createTable( dbUrl, dbUser, dbPassword );

		// 2. 사용자 데이터 입력 받기
		System.out.print( " 클라이언트 아이디: " );
		String clientId = scanner.nextLine();

		System.out.print( " 콜백 URL: " );
		String callbackUrl = scanner.nextLine();

		System.out.print( " 클라이언트 시크릿 키: " );
		String clientSecret = scanner.nextLine();

		System.out.print( " 로그인 링크 URL: " );
		String loginLink = scanner.nextLine();

		System.out.print( " 엑세스 URL: " );
		String accessUrl = scanner.nextLine();

		System.out.print( " 리스폰스 타입: " );
		String responseType = scanner.nextLine();

		System.out.print( " 리턴 타입: " );
		String returnType = scanner.nextLine();

		// 3. 데이터 저장 실행
		databaseModule.saveDataInput( dbUrl, dbUser, dbPassword, clientId, callbackUrl, clientSecret, loginLink, accessUrl, responseType,
				returnType );

		// Scanner 닫기
		scanner.close();

	}

}
