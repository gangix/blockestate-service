package com.dcs.docusign.dto;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class WebhookPayload {
    private String event;
    private Data data;


    public WebhookPayload(String event, Data data) {
        this.event = event;
        this.data = data;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getDeclinedReason() {
        if (data != null
                && data.getEnvelopeSummary() != null
                    && data.getEnvelopeSummary().getRecipients() != null
                        && CollectionUtils.isNotEmpty(data.getEnvelopeSummary().getRecipients().getSigners())){
            return data.getEnvelopeSummary().getRecipients().getSigners().get(0).getDeclinedReason();
        }
        return null;
    }

    public static class Data {
        private String envelopeId;
        private EnvelopeSummary envelopeSummary;

        public String getEnvelopeId() {
            return envelopeId;
        }

        public void setEnvelopeId(String envelopeId) {
            this.envelopeId = envelopeId;
        }

        public EnvelopeSummary getEnvelopeSummary() {
            return envelopeSummary;
        }

        public void setEnvelopeSummary(EnvelopeSummary envelopeSummary) {
            this.envelopeSummary = envelopeSummary;
        }
    }

    public static class EnvelopeSummary {
        private Recipients recipients;

        public Recipients getRecipients() {
            return recipients;
        }

        public void setRecipients(Recipients recipients) {
            this.recipients = recipients;
        }

        public static class Recipients {
            private List<Signer> signers;

            public List<Signer> getSigners() {
                return signers;
            }

            public void setSigners(List<Signer> signers) {
                this.signers = signers;
            }

            public static class Signer {
                private String declinedReason;

                public String getDeclinedReason() {
                    return declinedReason;
                }

                public void setDeclinedReason(String declinedReason) {
                    this.declinedReason = declinedReason;
                }
            }
        }
    }
}





