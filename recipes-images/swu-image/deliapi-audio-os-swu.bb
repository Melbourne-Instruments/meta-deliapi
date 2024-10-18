DESCRIPTION = "Recipe to build SWUpdate for DELIA Audio OS"

LICENSE = "CLOSED"

DISTRO_VERSION = "${SWU_VERSION}"

FILEEXTRAPATHS_prepend = "${THISDIR}/deliapi-audio-os-swu"
SRC_URI = "\
    file://sw-description \
"

IMAGE_DEPENDS = "deliapi-audio-os-image"

SWUPDATE_IMAGES = "delia-firmware"

SWUPDATE_IMAGES_FSTYPES[delia-firmware] = ".ext4.gz"

inherit swupdate
