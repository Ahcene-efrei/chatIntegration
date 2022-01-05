import { Injectable } from '@nestjs/common';
import { Message } from './message';
import * as fs from 'fs';

const badWords = ['fuck'];

@Injectable()
export class AppService {
  sendMessage(message: Message): Message {
    this.writeMessageToFile(message);
    let filteredContent = '';
    for (const word of message.content.split(' ')) {
      for (const badWord of badWords) {
        filteredContent += ' ';
        if (word.includes(badWord)) {
          filteredContent += '*'.repeat(word.length);
        } else {
          filteredContent += word;
        }
      }
    }
    message.content = filteredContent;
    this.writeMessageToFile(message, 'filtered');
    return message;
  }

  writeMessageToFile(message: Message, filename = 'clear') {
    fs.writeFileSync(
      `../not-censured-chat/dataIn/${filename}.json`,
      JSON.stringify(message),
    );
  }
}
