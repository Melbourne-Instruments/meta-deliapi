SRCREV = "eb458a348a67a0ae1ef777ee79c3bc8f085f5a34"
PV = "1.0.0+${AUTOREV}"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = "\
    file://1.patch \
"
