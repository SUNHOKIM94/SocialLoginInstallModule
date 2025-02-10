package com.ubintis.boot.input;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DatabaseModule {

	public void createTable( String dbUrl, String dbUser, String dbPassword ) {

		String createTableSQL = "CREATE TABLE ubi5_social_config(GOOGLE_CLIENT_ID varchar2(100),GOOGLE_CALLBACK_URL varchar2(100),GOOGLE_CLIENT_SECRET varchar2(100),GOOGLE_LOGIN_LINK varchar2(100),GOOGLE_ACCESS_URL varchar2(100),GOOGLE_RESPONSE_TYPE varchar2(100),GOOGLE_RETURN_TYPE varchar2(100))";

		try( Connection conn = DriverManager.getConnection( dbUrl, dbUser, dbPassword ); Statement stmt = conn.createStatement() ) {

			stmt.executeUpdate( createTableSQL );

		} catch( Exception e ) {
			dropTable( dbUrl, dbUser, dbPassword );
			e.printStackTrace();
		}
	}

	public void saveDataInput( String dbUrl, String dbUser, String dbPassword, String clientId, String callbackUrl, String clientSecret,
			String loginLink, String accessUrl, String responseType, String returnType ) {

		String sql = "INSERT INTO UBI5_SOCIAL_CONFIG (GOOGLE_CLIENT_ID, GOOGLE_CALLBACK_URL, GOOGLE_CLIENT_SECRET, GOOGLE_LOGIN_LINK, GOOGLE_ACCESS_URL, GOOGLE_RESPONSE_TYPE, GOOGLE_RETURN_TYPE) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try( Connection conn = DriverManager.getConnection( dbUrl, dbUser, dbPassword ); PreparedStatement pstmt = conn.prepareStatement( sql ) ) {

			pstmt.setString( 1, clientId );
			pstmt.setString( 2, callbackUrl );
			pstmt.setString( 3, clientSecret );
			pstmt.setString( 4, loginLink );
			pstmt.setString( 5, accessUrl );
			pstmt.setString( 6, responseType );
			pstmt.setString( 7, returnType );

			int rowsInserted = pstmt.executeUpdate();
			if( rowsInserted > 0 ) {
				System.out.println( " 데이터 저장에 성공하였습니다." );
			}

		} catch( Exception e ) {
			dropTable( dbUrl, dbUser, dbPassword );
			e.printStackTrace();
		}
	}

	// 테이블 삭제
	public void dropTable( String dbUrl, String dbUser, String dbPassword ) {

		String dropTableSQL = "DROP TABLE UBI5_SOCIAL_CONFIG"; // PURGE: 휴지통 없이 완전 삭제

		try( Connection conn = DriverManager.getConnection( dbUrl, dbUser, dbPassword ); Statement stmt = conn.createStatement() ) {

			stmt.executeUpdate( dropTableSQL );

		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
}