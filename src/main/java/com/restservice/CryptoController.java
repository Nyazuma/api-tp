			package com.restservice;

			import java.util.Locale;
			import java.util.concurrent.atomic.AtomicLong;

			import org.springframework.web.bind.annotation.GetMapping;
			import org.springframework.web.bind.annotation.RequestParam;
			import org.springframework.web.bind.annotation.RestController;

			@RestController
			public class CryptoController {

				@GetMapping("/cesar-crypt")
				public String cesarCrypt(@RequestParam(value = "text", defaultValue = "World") String text,
										 @RequestParam(value = "gap", defaultValue = "3") String gapstr) {
					String word = "";
					int gap = Integer.parseInt(gapstr);
					text = text.toUpperCase();
					for(int i = 0; i<text.length(); i++){
						char c = text.charAt(i);
						if (c!=' '){
							int cCode = (int)c;
							int newCode = (((cCode)+gap)%91);
							if(newCode < 65){
								newCode = newCode + 65;
							}
							char cNew = (char)newCode;
							word += cNew;
			} else {
							word += ' ';
						}


					}

					return word;
				}


				@GetMapping("/cesar-decrypt")
				public String cesarDecrypt(@RequestParam(value = "text", defaultValue = "World") String text,
										   @RequestParam(value = "gap", defaultValue = "3") String gapstr) {
					String word = "";
					int gap = Integer.parseInt(gapstr);
					text = text.toUpperCase();
					for(int i = 0; i<text.length(); i++){
						char c = text.charAt(i);
						if (c!=' '){
							System.out.println("================================================================");
							int cCode = (int)c;
							System.out.println(cCode);
							int ncode = cCode - 65;
							System.out.println(ncode);
							int modulo = 26;
							// Le module ne fonctionn pas correctement sur les nombres négatifs et c'est pourquoi on doit ajouter  26 (= nombre de letrres dans l'alphabet)
							int newCode = ((ncode - gap) + (modulo* 5)) % modulo;
							System.out.println("newCode : " + newCode);
							newCode += 65;
							char cNew = (char)newCode;
							word += cNew;
						} else {
							word += ' ';
						}


					}

					return word;
				}

				@GetMapping("/vigenere-crypt")
				public String vigenereCrypt(@RequestParam(value = "text", defaultValue = "World") String text,
										   @RequestParam(value = "key", defaultValue = "secret") String key) {
					String word = "";
					int numberOfLetters = 26;
					text = text.toUpperCase();
					key = key.toUpperCase();
					// Rallongement de la cle
					int textLength = text.length();
					int keyLength = key.length();
					if(keyLength < textLength){
						while(key.length() < textLength){
							key += key;
						}
					}

					for(int i = 0; i<text.length(); i++){
						char c = text.charAt(i);
						char k = key.charAt(i);
						if (c!=' '){
							int textChar = (int)c - 65;
							int keyChar = (int)k - 65;
							int resChar = (textChar + keyChar) % numberOfLetters;
							int resCharAscii = resChar + 65;
							char cNew = (char)resCharAscii;
							word += cNew;
						}}





					return word;
				}

				@GetMapping("/vigenere-decrypt")
				public String vigenereDecrypt(@RequestParam(value = "text", defaultValue = "World") String text,
											@RequestParam(value = "key", defaultValue = "secret") String key) {
					String word = "";
					int numberOfLetters = 26;
					text = text.toUpperCase();
					key = key.toUpperCase();
					// Rallongement de la cle
					int textLength = text.length();
					int keyLength = key.length();
					if(keyLength < textLength){
						while(key.length() < textLength){
							key += key;
						}
					}

					for(int i = 0; i<text.length(); i++){
						char c = text.charAt(i);
						char k = key.charAt(i);
						if (c!=' '){
							int textChar = (int)c - 65;
							int keyChar = (int)k - 65;
							int resChar = (textChar - keyChar) ;
							while(resChar < 0){
								resChar += numberOfLetters;
							}
							resChar = resChar % numberOfLetters;
							int resCharAscii = resChar + 65;
							char cNew = (char)resCharAscii;
							word += cNew;
						}}





					return word;
				}
			}
