@Grab('org.slf4j:slf4j-simple:1.7.21') 
@Grab('org.subethamail:subethasmtp:3.1.7')

import groovy.util.logging.*
import org.subethamail.smtp.*
import org.subethamail.smtp.server.*

class MessageHandlerFactoryImpl implements MessageHandlerFactory {
    @Override
    MessageHandler create(MessageContext ctx) {
            return new MessageHandlerImpl(ctx)
        }
}

@Log
class MessageHandlerImpl implements MessageHandler {
    MessageContext context
 
    MessageHandlerImpl() {}
 
    MessageHandlerImpl(MessageContext context) {
        this.context = context
    }
 
    @Override
    void from(String from) {
        log.info "FROM: ${from}"
    }
 
    @Override
    void recipient(String recipient) {
        log.info "RECIPIENT: ${recipient}"
    }
 
    @Override
    void data(InputStream data) {
        log.info "DATA"          
    }
 
    @Override
    void done() {
        log.info "DONE"
    }
}

SMTPServer smtpServer  = new SMTPServer(new MessageHandlerFactoryImpl())
 
smtpServer.hostName = 'localhost'
smtpServer.port = 25000
smtpServer.start()